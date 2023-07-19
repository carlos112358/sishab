package tech.ada.sishab.service;

import tech.ada.sishab.io.ObraSisHabRecord;

import java.util.*;

public class SisHabService {


    private Map<Integer, ObraSisHabRecord> obraMap = new HashMap<>();
    private Map<String, List<Integer>> fullTextMap = new HashMap<>();

    public static List<ObraSisHabRecord> removerDuplicatas(List<ObraSisHabRecord> listaDuplicada){
        return new ArrayList<>(new HashSet<>(listaDuplicada));
    };

    public static void sortByState(List<ObraSisHabRecord> listaDuplicada){
       Collections.sort(listaDuplicada, Comparator.comparing(ObraSisHabRecord::txtUf));
    }

    public static void sortByDate(List<ObraSisHabRecord> listaDuplicada){
        Collections.sort(listaDuplicada, Comparator.comparing(ObraSisHabRecord::dteAssinaturaContrato));
    }
    public void fillObraMap(List<ObraSisHabRecord> listaDuplicada){
        List<ObraSisHabRecord> listaDeduplicada =  removerDuplicatas(listaDuplicada);
        listaDeduplicada.forEach(o -> {
            obraMap.put(o.id(), o);
            indexObraObj(o);
        });
    }

    //index text fields (just txtNomeEmpreendimento for now)
    private void indexObraObj(ObraSisHabRecord o) {
        String text = o.txtNomeEmpreendimento();
        if (text == null || text.isBlank())
            return;
        String lowerCaseText = text.toLowerCase().trim();

        String[] termsList = lowerCaseText.split(" ");

        for(String term : termsList){
            List<Integer> indexes = fullTextMap.get(term);

            if(indexes==null){
                indexes = new ArrayList<>();
                fullTextMap.put(term, indexes);
            }
            indexes.add(o.id());
        }
    }

    public List<ObraSisHabRecord> fulltextSearch(String text){
        ArrayList<ObraSisHabRecord> returnList = new ArrayList<>();
        if (text!=null && !text.isBlank()){
            String[] termsList = text.toLowerCase().split(" ");
            List<Integer> indexList = new ArrayList<>();
            for(String term : termsList){
                indexList.addAll(fullTextMap.get(term));
            }
            for(int index : indexList){
                returnList.add(obraMap.get(index));
            }
        }
        return returnList;
    }

}
