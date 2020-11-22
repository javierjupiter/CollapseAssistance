import java.util.regex.Pattern;

public class Validaciones {


    private String regexCURP = "^[A-Z][AEIOU][A-Z]{2}[0-9]{2}" +
        "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
        "[HM]" +
        "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
        "[B-DF-HJ-NP-TV-Z]{3}" +
        "[0-9A-Z]{1}[0-9]$";
    private Pattern patronCURP = Pattern.compile(regexCURP);

    private String regexFecha = "^(19[5-9][0-9]|20[0-2][0-9])-(" +  //Año en AAAA acepta de 1950 a 2029
                            "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])|" + //Meses con 31 días
                            "(0[469]|11)-(0[1-9]|[12][0-9]|30)|" + //Meses con 30 días
                            "02-(0[1-9]|[12][0-9]))$"; //Febrero
    private Pattern patronFecha = Pattern.compile(regexFecha);

    private String regexNombre = "^(([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)[ ]*)+$"; //Acepta solo con la primera letra de cada palabra con mayusculas, las siguientes deben ser minusculas
    private Pattern patronNombre = Pattern.compile(regexNombre);

    private String regexCadenas = "^(([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)[ \\.,¿?-_\\*\\+/]*)+$";
    private Pattern patronCadenas = Pattern.compile(regexCadenas);


    public boolean validarCURP(String curpDato){
        if (patronCURP.matcher(curpDato).matches()) {
            return true;
        } else {
            System.out.println("CURP invalido, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarFecha(String fecha){
        if (patronFecha.matcher(fecha).matches()){
            return true;
        } else{
            System.out.println("Fecha invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarNombre(String cadena){
        if (patronNombre.matcher(cadena).matches()){
            return true;
        } else {
            System.out.println("Cadena invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarCadenas(String cadena){
        if (patronCadenas.matcher(cadena).matches()){
            return true;
        } else {
            return false;
        }

    }
}
