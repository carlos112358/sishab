package tech.ada.sishab.service;

import tech.ada.sishab.io.ObraSisHabRecord;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SisHabService {


    public static List<ObraSisHabRecord> removerDuplicatas(List<ObraSisHabRecord> listaDuplicada){
        return new ArrayList<>(new HashSet<>(listaDuplicada));
    };
}
