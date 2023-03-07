package com.dev.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DateTest {

    public static int DIAS_LIMITES_ABERTURA_RELATO = 5;

    public static void main(String[] args) throws ParseException {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        OffsetDateTime now = OffsetDateTime.now();

        System.out.println(now);
        System.out.println(remaingTimeCalculator(now));
        System.out.println(zonedDateTime.toLocalDateTime());

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(date));

        //ISO 8601
        SimpleDateFormat sdfIso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        System.out.println(sdfIso.format(date));

        //Wed Jan 20 06:00:00 BRT 2021
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 15, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.add(Calendar.DAY_OF_MONTH, 5);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        System.out.println(calendar.getTime());

        //Sun Jan 10 12:00:00 BRT 2021
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        System.out.println(calendar.getTime());

        //Wed Feb 10 18:00:00 BRT 2021
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        System.out.println(calendar.getTime());

        System.out.println("Calcular a diferença de dias entre datas");
        Date dia15012021 = calendar.getTime();
        Date hoje = new Date();

        long timestamp = hoje.getTime() - dia15012021.getTime();
        long qtDias = TimeUnit.MILLISECONDS.toDays(timestamp);
        System.out.println(qtDias);

        LocalDate startDate = LocalDate.of(2021, 1, 15);
        LocalDate endDate = LocalDate.of(2021, 1, 16);

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println(days);

        LocalDateTime startDate2 = LocalDateTime.of(2021, 1, 15, 9, 0);
        LocalDateTime endDate2 = LocalDateTime.of(2021, 1, 16, 8, 59);

        long days2 = ChronoUnit.DAYS.between(startDate2, endDate2);
        System.out.println(days2);

        long minutes = ChronoUnit.MINUTES.between(startDate2, endDate2);
        System.out.println(minutes);

        Period period = Period.between(startDate, endDate);
        System.out.println(period);

        Duration duration = Duration.between(startDate2, endDate2);
        System.out.println(duration);


        System.out.println("Novo Calcular a diferença de dias entre datas");
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        var inicio = LocalDateTime.parse("2020-01-01T00:00:00", formatter);
        var fim = LocalDateTime.parse("2020-01-02T00:00:00", formatter);
        //var fim = LocalDateTime.parse("2020-01-01T00:00:00", formatter);

        long diasDiferenca = ChronoUnit.DAYS.between(inicio, fim);
        System.out.println(diasDiferenca);

        LocalDateTime ultimoDiaDoMesAnterior = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime primeiroDiaDoMesAnterior = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());

        System.out.println(ultimoDiaDoMesAnterior.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(primeiroDiaDoMesAnterior.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        LocalDate ontem = LocalDate.now().minusDays(1);
        System.out.println("Ontem: " + ontem);

        System.out.println("=======");
        LocalDateTime primeiroM2 = LocalDateTime.now().minusMonths(2).with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime ultimoM1 = LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("primeiro dia: " + primeiroM2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("ultimo dia: " + ultimoM1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        System.out.println("=======");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date data = simpleDateFormat.parse("2022-01-01");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat2.format(data));


        System.out.println("=======");

        String dataInicio = "2022-01-01";
        String dataFim = "2022-02-01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dataInicio2 = LocalDate.parse(dataInicio, dateTimeFormatter).atStartOfDay().withSecond(01);
        LocalDateTime dataFim2 = LocalDate.parse(dataFim, dateTimeFormatter).atStartOfDay();
        System.out.println(dataInicio2);
        System.out.println(dataFim2);

        String dataConvert = "2000-05-12 18:26:30";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Converter date " + parseDate(dataConvert, sdf2));


        LocalDateTime startDate3 = LocalDateTime.of(2021, 1, 15, 9, 0);
        LocalDateTime endDate3 = LocalDateTime.of(2021, 1, 16, 8, 59);
        System.out.println("A data " + startDate3 + " eh apos a data " + endDate3 + " ?");
        System.out.println(startDate3.isAfter(endDate3));

        DateTimeFormatter fmt = DateTimeFormatter
                .ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        LocalDate sabado = LocalDate.parse("15/10/2022", fmt);
        LocalDate sexta = LocalDate.parse("14/10/2022", fmt);
        LocalDate now1 = LocalDate.now();  //14/10/2022

        System.out.println(sabado.isAfter(now1));
        System.out.println(sabado.isBefore(now1));
        System.out.println(sexta.isEqual(sabado));
        System.out.println(sexta.isEqual(now1));

        System.out.println(fimDeSemana(now1));
        System.out.println(fimDeSemana(sabado));

        LocalDate dataInicioLei = LocalDate.of(2023, 01, 01);
        LocalDate dataIniIgualLei = LocalDate.of(2023, 01, 01);
        LocalDate dataIni = LocalDate.of(2022, 01, 01);
        LocalDate dataIni2 = LocalDate.of(2023, 01, 02);
        LocalDate hj = LocalDate.now();

        System.out.println("01/01/2023 >= 01/01/2023 = " + (dataIniIgualLei.isAfter(dataInicioLei) || dataIniIgualLei.isEqual(dataInicioLei)));
        System.out.println("01/01/2022 >= 01/01/2023 = " + (dataIni.isAfter(dataInicioLei) || dataIni.isEqual(dataInicioLei)));
        System.out.println("02/01/2023 >= 01/01/2023 = " + (dataIni2.isAfter(dataInicioLei) || dataIni2.isEqual(dataInicioLei)));
        System.out.println("Hoje >= 01/01/2023 = " + (hj.isAfter(dataInicioLei)|| hj.isEqual(dataInicioLei)));
//        01/01/2023 >= 01/01/2023 = true
//        01/01/2022 >= 01/01/2023 = false
//        02/01/2023 >= 01/01/2023 = true
//        Hoje >= 01/01/2023 = true

    }

    public static boolean fimDeSemana(LocalDate ld) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

    public static String remaingTimeCalculator(OffsetDateTime offsetDateTime){
        if (Objects.isNull(offsetDateTime)){
            return null;
        }
        offsetDateTime = offsetDateTime.plusDays(DIAS_LIMITES_ABERTURA_RELATO);
        return String.format("%04d-%02d-%02dT%02d:%02d:%02d.%03d", offsetDateTime.getYear(), offsetDateTime.getMonthValue(),
                offsetDateTime.getDayOfMonth(), offsetDateTime.getHour(), offsetDateTime.getMinute(), offsetDateTime.getSecond(), offsetDateTime.getNano());
    }

    private static Date parseDate(String readAndTrim, DateFormat dateFormat) {
        try {
            return dateFormat.parse(readAndTrim);
        } catch (ParseException var5) {
            String pattern;
            if (dateFormat instanceof SimpleDateFormat) {
                pattern = ((SimpleDateFormat)dateFormat).toPattern();
            } else {
                pattern = dateFormat.toString();
            }

            throw new IllegalArgumentException(var5.getMessage() + ", format: [" + pattern + "]");
        }
    }

}


