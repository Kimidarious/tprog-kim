package Exercicio2_LocalTime;

import java.time.format.DateTimeFormatter;

public class LocalTime {

    public static void main(String[] args) {
        System.out.println("🕐 EXERCÍCIO 2 - Usando LocalTime");
        System.out.println("=" .repeat(50));

        // 1. Mostrar a hora atual do sistema
        java.time.LocalTime horaAtual = java.time.LocalTime.now();
        System.out.println("⏰ Hora atual do sistema: " + horaAtual);

        // Formatação mais limpa (sem nanossegundos)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("🎯 Hora formatada: " + horaAtual.format(formatoHora));

        // Componentes separados
        System.out.println("\n📍 Componentes do horário:");
        System.out.println("   • Hora: " + horaAtual.getHour() + "h");
        System.out.println("   • Minutos: " + horaAtual.getMinute() + "min");
        System.out.println("   • Segundos: " + horaAtual.getSecond() + "s");

        // 2. Adicionar 2 horas e 30 minutos ao horário atual
        java.time.LocalTime horaFutura = horaAtual.plusHours(2).plusMinutes(30);

        // 3. Exibir a hora antes e depois da adição
        System.out.println("\n📝 COMPARAÇÃO:");
        System.out.println("   • ANTES: " + horaAtual.format(formatoHora));
        System.out.println("   • DEPOIS (+2h 30min): " + horaFutura.format(formatoHora));

        // Informações extras
        System.out.println("\n📊 Detalhes da operação:");
        System.out.println("   • Horas adicionadas: 2h");
        System.out.println("   • Minutos adicionados: 30min");
        System.out.println("   • Total adicionado: 2h 30min");

        // Verificar se passou da meia-noite
        if (horaFutura.isBefore(horaAtual)) {
            System.out.println("   ⚠️ Atenção: A hora futura passou da meia-noite!");
        }

        // Período do dia
        int hora = horaAtual.getHour();
        String periodo;
        if (hora >= 6 && hora < 12) {
            periodo = "Manhã";
        } else if (hora >= 12 && hora < 18) {
            periodo = "Tarde";
        } else if (hora >= 18 && hora < 24) {
            periodo = "Noite";
        } else {
            periodo = "Madrugada";
        }

        System.out.println("   🌅 Período do dia: " + periodo);
    }
}
