package com.dev.utils;

import com.dev.models.Page;
import com.dev.models.Pessoa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PaginacaoUtils {

    public static void main(String[] args) {

        List<Pessoa> pessoas = List.of(
                new Pessoa("Rodrigo", 30),
                new Pessoa("Raquel", 30),
                new Pessoa("Gustavo", 9),
                new Pessoa("Ailton", 50),
                new Pessoa("Romario", 36),
                new Pessoa("Edmundo", 28),
                new Pessoa("Bebeto", 33),
                new Pessoa("Tafarel", 32),
                new Pessoa("Ronaldo", 17),
                new Pessoa("Edilson", 25),
                new Pessoa("William", 19));

        int itemsPerPage = 3;
        int targetPage = 1;

        paginate(pessoas, itemsPerPage, targetPage);
    }

    public static void paginate(List<?> dataList, int itemsPerPage, int targetPage) {
        int totalPages = (int) Math.ceil((double) dataList.size() / itemsPerPage);

        if (targetPage < 1 || targetPage > totalPages) {
            System.out.println("Página inválida.");
            return;
        }

        int startIndex = (targetPage - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, dataList.size());

        List<?> currentPageData = dataList.subList(startIndex, endIndex);
        Page page = new Page(currentPageData, dataList.size(), totalPages, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println("Página atual " + targetPage);
        System.out.println("Total de páginas " + totalPages);

        currentPageData.forEach(System.out::println);

        System.out.println("==================");

        System.out.println(page);
    }
}
