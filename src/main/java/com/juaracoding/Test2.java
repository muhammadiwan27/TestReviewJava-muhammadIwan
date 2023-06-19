package com.juaracoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> trailers = new ArrayList<>(Arrays.asList(
                ":T1:202112S0AL3",
                ":T2:CDE5432100 SOALO03 ABCDE12345 XAS SKILL TEST ESSAY .DTSOAL3/2112/AB000000011 OD:0001234500",
                ":T1:202111SOAL3",
                ":T2:EFG2451300 SOALO03 EFGHI25134 XAS SKILL TEST ESSAY .DTSOAL3/2111/BC000011100 OD:0003452100",
                ":T1:202110S0AL3",
                ":T2:H1J2145300 SOALO03 JKLMN52431 XAS SKILL TEST ESSAY .DTSOAL3/2110/DE210031010 0D:0001524300"
        ));
        List<String> modifiedTrailers = modifyTrailerPositions(trailers);

        for (String trailer : modifiedTrailers) {
            System.out.println(trailer);
        }
    }
    private static List<String> modifyTrailerPositions(List<String> trailers) {
        List<String> modifiedTrailers = new ArrayList<>();
        int trailerCount = trailers.size();
        int trailerIndex = 0;

        while (trailerIndex < trailerCount) {
            String currentTrailer = trailers.get(trailerIndex);
            if (currentTrailer.startsWith(":T2:")) {
                modifiedTrailers.add(currentTrailer.replaceFirst(":T2:", ":T" + (trailerIndex + 1) + ":"));
            } else {
                modifiedTrailers.add(currentTrailer);
            }
            trailerIndex++;
        }
        for (int i = 0; i < 2; i++) {
            String currentTrailer = modifiedTrailers.get(i);
            modifiedTrailers.set(i, currentTrailer.replaceFirst(":T1:", ":T" + (i + 4) + ":"));
        }
        return modifiedTrailers;
    }
}