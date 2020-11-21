import java.util.regex.Pattern;

public class Validaciones {

    private String regexC =
                    "[A-Z]{1}[AEIOU]{1}[A-Z]{22}[0-9]{2}" + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" + "[HM]{1}" + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" + "[B-DF-HJ" + "-NP-TV-Z]{3}" + "[0-9A-Z]{1}[0-9]{1}$";
    private Pattern patronC = Pattern.compile(regexC);

    //private String regexF = "(0[1-2]|1[0 9]|2[0-9]|3[0-1])" + "(-)" + "[0-9] {1} [0-9] {1}" + "(-)" + "[0-9] {1} [0-9] {1}$";
    //private String regexF = "(19|20)" + "[0-9]{1}[0-9]{1}" + "(-)" + "[0-1][1-9]";
    //private String regexF = "((19|20)\\d\\d)-(0[1-9]|1[012])-([012][0-9]|3[012])$";
    //private String regexF = "(((\\d\\d)(0[48]|[2468][048]|[13579][26])|([02468][048]|[13579][26])(00))(02)([012]\\d))|(\\d\\d([02468][1235679]|[13579][01345789])(02)([01]\\d|2[012345678]))|(\\d\\d\\d\\d((0[13578]|1[02])([012]\\d|3[01])|((0[46]|11)([012]\\d|30))))";
    //private String regexF = "[1, 2][0-9]{3}";
    private String regexF = "\\d{1,2}-\\d{1,2}-\\{4}";
    private Pattern patronF = Pattern.compile(regexF);



    public boolean validarCURP(String curpDato){
        if (!patronC.matcher(curpDato).matches() && curpDato.length() == 18) {
            return true;
        } else {
            System.out.println("CURP invalido, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarFecha(String fecha){
        System.out.println("Fecha : '" + fecha + "'\tLargo: " + fecha.length());
        if (!patronF.matcher(fecha).matches() && fecha.length() == 4){
            return true;
        } else{
            System.out.println("Fecha invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarNombre(String nombre){
        if (!nombre.equals("")){
            return true;
        } else {
            System.out.println("Nombre vacio, ingrese nuevamente");
            return false;
        }
    }
}
