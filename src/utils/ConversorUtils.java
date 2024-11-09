package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorUtils {
	public static String DateTimeToUser(String dateTime) {
		// Define o formatador para a data original
		DateTimeFormatter formatadorOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Define o formatador para a nova data
		DateTimeFormatter formatadorNovo = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		// Converte a string original para LocalDateTime
		LocalDateTime dataHora = LocalDateTime.parse(dateTime, formatadorOriginal);
		
		// Formata a data para o novo padrão
        String dataFormatada = dataHora.format(formatadorNovo);

		return dataFormatada;
	}
}
