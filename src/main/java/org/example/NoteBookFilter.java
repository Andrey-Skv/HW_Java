package org.example;

import java.util.*;
public class NoteBookFilter {

    public static void main(String[] args) {
        NoteBookFilter hw = new NoteBookFilter();
        Map<String, String> filteringСriteria = hw.getFilteringCriteriaFromUser();
        List<Notebook> list = hw.initListNotebooks();
        List<Notebook> filteredList = hw.filter(filteringСriteria, list);
        hw.printNotebookList(filteredList);
    }

    public List<Notebook> initListNotebooks() {
        List<Notebook> listNotebooks = new ArrayList<Notebook>(Arrays.asList(
                new Notebook(16, "Intel", "Palit nVidia GeForce RTX 4090 GameRock OmniBlack 24576Mb", "E5-4617", "Western Digital WD Black 500 ГБ WD5000LPSX", "Windows", 50000.00, 'g'),
                new Notebook(16, "Intel", "Palit nVidia GeForce RTX 4090 GameRock OmniBlack 24576Mb", "E5-4617", "Western Digital WD Black 500 ГБ WD5000LPSX", "Windows", 50000.00, 'b'),
                new Notebook(18, "Intel", "Palit nVidia GeForce RTX 4090 GameRock OmniBlack 24576Mb", "E5-4617", "Western Digital WD Black 500 ГБ WD5000LPSX", "Linux", 50000.00, 'g'),
                new Notebook(16, "Intel", "Palit nVidia GeForce RTX 4090 GameRock OmniBlack 24576Mb", "E5-4617", "Western Digital WD Black 500 ГБ WD5000LPSX", "Linux", 50000.00, 'b')));

        return listNotebooks;
    }

    public List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks) {
        List<Notebook> result = new ArrayList<Notebook>();
        for (Notebook notebook : notebooks) {
            if (notebook.getCondition() == params.get("condition").charAt(0) && notebook.getDiagonal() == Integer.parseInt(params.get("diagonal")) && notebook.getOperatingSystem().equalsIgnoreCase(params.get("operatingSystem"))) {
                result.add(notebook);
            }

        }
        return result;
    }

    public Map<String, String> getFilteringCriteriaFromUser() {
        System.out.println("Выберите критерии фильтрации: ");
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filteringCriteria = new HashMap<>();
        System.out.print("Размер диагонали (дюймы): ");
        filteringCriteria.put("diagonal", scanner.nextLine());
        System.out.print("Операционная система: ");
        filteringCriteria.put("operatingSystem", scanner.nextLine());
        System.out.print("Состояние (g-отличное, b-хорошее): ");
        filteringCriteria.put("condition", scanner.nextLine());
        return filteringCriteria;
    }

    public void printNotebookList(List<Notebook> notebooks) {
        if (notebooks.size() == 0) {
            System.out.println("Нет ноутбуков, удовлетворяющих критериям фильтрации");
        } else {
            System.out.println("Список ноутбуков, удовлетворяющих критериям фильтрации:");
            for (Notebook notebook : notebooks) {
                System.out.println(notebook);
            }
        }
    }
}