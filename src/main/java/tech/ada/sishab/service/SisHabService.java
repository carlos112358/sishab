package tech.ada.sishab.service;

import tech.ada.sishab.io.ObraSisHabRecord;

import java.util.*;

public class SisHabService {


    public static List<ObraSisHabRecord> removerDuplicatas(List<ObraSisHabRecord> listaDuplicada){
        return new ArrayList<>(new HashSet<>(listaDuplicada));
    };

    public static void sortByState(List<ObraSisHabRecord> listaDuplicada){
       Collections.sort(listaDuplicada, Comparator.comparing(ObraSisHabRecord::txtUf));
    }

    public static void sortByDate(List<ObraSisHabRecord> listaDuplicada){
        Collections.sort(listaDuplicada, Comparator.comparing(ObraSisHabRecord::dteAssinaturaContrato));
    }
}
