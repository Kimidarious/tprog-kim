//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Exercicio1_LocalDate;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class ExercicioLocalDate {
    public static void main(String[] args) {
        System.out.println("=== EXERCICIO 1 - LocalDate ===");
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual do sistema: ");
        System.out.println("Data completa:" + String.valueOf(dataAtual));
        System.out.println("Data formatada: " + dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\n Componentes da data separadamente");
        int dia = dataAtual.getDayOfMonth();
        int mes = dataAtual.getMonthValue();
        int ano = dataAtual.getYear();
        System.out.println("Dia: " + dia);
        System.out.println("Mês (número): " + mes);
        System.out.println("Ano: " + ano);
        System.out.println("\nInformações adicionais:");
        PrintStream var10000 = System.out;
        Month var10001 = dataAtual.getMonth();
        TextStyle var10002 = TextStyle.FULL;
        var10000.println("Mês: " + var10001.getDisplayName(var10002, Locale.of("pt", "BR")));
        var10000 = System.out;
        DayOfWeek var8 = dataAtual.getDayOfWeek();
        var10002 = TextStyle.FULL;
        var10000.println("Dia da semana: " + var8.getDisplayName(var10002, Locale.of("pt", "BR")));
        System.out.println("Dia do ano: " + dataAtual.getDayOfYear());
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nAdicionando 10 dias à data atual");
        LocalDate dataFutura = dataAtual.plusDays(10L);
        System.out.println("Data atual: " + dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data + 10 dias: " + dataFutura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("\n Comparação");
        var10000 = System.out;
        Period var9 = Period.between(dataAtual, dataFutura);
        var10000.println("Diferença: " + var9.getDays() + " dias");
    }
}
