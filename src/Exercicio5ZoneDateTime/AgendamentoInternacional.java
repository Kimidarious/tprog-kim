package Exercicio5ZoneDateTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AgendamentoInternacional {
    public static void main(String[] args) {
        ZoneId zonaHorariaSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime eventoSaoPaulo = ZonedDateTime.of(2025, 10, 15,
                                                        14, 0, 0, 0,
                                                        zonaHorariaSaoPaulo);

        ZoneId zonaNovaYork = ZoneId.of("America/New_York");
        ZoneId zonaToquio = ZoneId.of("Asia/Tokyo");
        ZoneId zonaLondres = ZoneId.of("Europe/London");

        ZonedDateTime eventoNovaYork = eventoSaoPaulo.withZoneSameInstant(zonaNovaYork);
        ZonedDateTime eventoToquio = eventoSaoPaulo.withZoneSameInstant(zonaToquio);
        ZonedDateTime eventoLondres = eventoSaoPaulo.withZoneSameInstant(zonaLondres);

        DateTimeFormatter formatadorDetalhado = DateTimeFormatter.ofPattern(
                                                    "dd 'de' MMMM 'de' yyyy 'às' HH:mm '('z')'",
                                                    new  Locale("pt", "BR"));

        DateTimeFormatter formatadorInternacional = DateTimeFormatter.ofPattern(
                                                    "MMMM dd, yyyy 'at' HH:mm '('z')'",
                                                    Locale.ENGLISH);

        System.out.println("=".repeat(50));
        System.out.println("     AGENDAMENTO DE EVENTO INTERNACIONAL     ");
        System.out.println("=".repeat(50));

        System.out.println("Evento original:");
        System.out.println(" São Paulo: " + eventoSaoPaulo.format(formatadorDetalhado));

        System.out.println("\n HORÁRIO CONVERTIDOS:");
        System.out.println("  ├─ Nova York: " + eventoNovaYork.format(formatadorInternacional));
        System.out.println("  ├─ Tóquio: " + eventoToquio.format(formatadorInternacional));
        System.out.println("  └─ Londres: " + eventoLondres.format(formatadorInternacional));

        System.out.println("\n  DETALHES TÉCNICOS");
        System.out.println("  ├─ Diferença SP -> NY: " + calcularDiferencaHoras(eventoSaoPaulo, eventoNovaYork) + " horas");
        System.out.println("  ├─ Diferença SP -> Tokyo: " + calcularDiferencaHoras(eventoSaoPaulo, eventoToquio) + " horas");
        System.out.println("  └─ Diferença SP -> Londres: " + calcularDiferencaHoras(eventoSaoPaulo, eventoLondres) + " horas");

        System.out.println("\nOBSERVAÇÕES:");
        verificarMudancaDia(eventoSaoPaulo, eventoNovaYork, "Nova York");
        verificarMudancaDia(eventoSaoPaulo, eventoToquio, "Tóquio");
        verificarMudancaDia(eventoSaoPaulo, eventoLondres, "Londres");

        System.out.println("\n FORMATO ISO 8601:");
        System.out.println(" São Paulo: " + eventoSaoPaulo.toString());
        System.out.println(" Nova York: " + eventoNovaYork.toString());
        System.out.println(" Tóquio: " + eventoToquio.toString());
        System.out.println(" Londres: " + eventoLondres.toString());
    }

    private static long calcularDiferencaHoras(ZonedDateTime origem, ZonedDateTime destino) {
        return origem.getOffset().getTotalSeconds() / 3600 -
                destino.getOffset().getTotalSeconds() / 3600;
    }

    private static void verificarMudancaDia(ZonedDateTime origem, ZonedDateTime destino, String cidade) {
        if (origem.toLocalDate().compareTo(destino.toLocalDate()) != 0) {
            if (destino.toLocalDate().isAfter(origem.toLocalDate())) {
                System.out.println(" Em " + cidade + ", o evento será no dia seguinte!");

            } else {
                System.out.println(" Em " + cidade + ", o evento será no dia anterior!");
            }
        }
    }
}
