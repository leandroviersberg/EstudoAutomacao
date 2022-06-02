package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	//Retorno de String  data e hora atuais 
	public static String dataHoraParaArquivo() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyymmddhhmmss").format(ts);
	}

}
