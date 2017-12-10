package pl.sda.poznan.sort.measure;

import pl.sda.poznan.sort.BubbleSort;
import pl.sda.poznan.sort.BucketSort;
import pl.sda.poznan.sort.InsertionSort;
import pl.sda.poznan.sort.MergeSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Program wypelniajacy losowymi wartosciami tablice
 * i mierzacy czas sorotwania
 * z wykorzystaniem zaimplementowynych metod sorotwania
 */

public class App {
    public static void main(String[] args) {
        //sout -> podaj ile el wylosowac
        System.out.println("Podaj ilosc elementow do wylosowania:");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        //utworzyc tablice o takim rozmiarze
        int[] array = new int[arraySize];
        //wypelnic ja losowymi wartosciami
        Random rd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(100);
            //System.out.print(array[i] + " | ");
        }

        //pomocnicza tablica zeby obie metody sortowania otrzymaly te same tablice
        //a nie juz posortowane
        //w celu porownania
        //kopiujemy do pomocniczej tablicy -> toSort i toMergeSort


        //posortowac babelkowo - wyswietlic czas
        System.out.println("Sortowanie babelkowe");
        int[] toSort = Arrays.copyOf(array, arraySize);
        System.out.println("Rozpoczynam sortowanie.............");
        long startTime = System.currentTimeMillis();
        BubbleSort.sort(toSort);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Zakonczono sortowanie.... Czas operacji to: " + time);
        System.out.println();

        //posortowac mergeSort - wyswietlic czas

        System.out.println("Sortowanie przez scalanie");
        int[] toMergeSort = Arrays.copyOf(array, arraySize);
        MergeSort mergeSort = new MergeSort();
        System.out.println("Rozpoczynam sortowanie.............");
        long startMergeTime = System.currentTimeMillis();
        mergeSort.sort(toMergeSort);
        long endMergeTime = System.currentTimeMillis();
        long mergeTime = endMergeTime - startMergeTime;
        System.out.println("Zakonczono sortowanie.... Czas operacji to: " + mergeTime);
        System.out.println();


        //posortowac kubałkowo - wyswietlic czas
        System.out.println("Sortowanie kubelkowe");
        int[] toBucketSort = Arrays.copyOf(array, arraySize);
        System.out.println("Rozpoczynam sortowanie.............");
        long startBucketTime = System.currentTimeMillis();
        BucketSort.sort(toBucketSort, 100);
        long endBucketTime = System.currentTimeMillis();
        long bucketTime = endBucketTime - startBucketTime;
        System.out.println("Zakonczono sortowanie.... Czas operacji to: " + bucketTime);
        System.out.println();

        //posortowac przez wstawianie - wyswietlic czas
        System.out.println("Sortowanie przez wstawianie");
        int[] toInsertionSort = Arrays.copyOf(array, arraySize);
        System.out.println("Rozpoczynam sortowanie.............");
        long startInsertionTime = System.currentTimeMillis();
        InsertionSort.sort(toInsertionSort);
        long endInsertionTime = System.currentTimeMillis();
        long insertionTime = endInsertionTime - startInsertionTime;
        System.out.println("Zakonczono sortowanie.... Czas operacji to: " + insertionTime);
    }
}
