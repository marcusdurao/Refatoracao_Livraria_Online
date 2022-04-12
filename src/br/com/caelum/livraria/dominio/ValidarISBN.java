package br.com.caelum.livraria.dominio;

public class ValidarISBN {
    private String valor;

    public ValidarISBN( String valor ) {
        this.valor = valor;
    }

    public boolean validar(){
        if (valor == null) return false;

        String valorSomenteNumeros = valor.replaceAll("-", "");
        if(valorSomenteNumeros.length() != 13) return false;

        try{
            int tot = 0;
            for (int i = 0; i < 12; i++ ){

                //Utilizado a técnica de extração de método
                //int digito = Integer.parseInt(valor.substring(i, i + 1));

                int digito = getParseInt(valor.substring(i, i + 1));
                tot += (i % 2 == 0) ? digito * 1 : digito * 3;
            }

            int checksum = 10 - (tot % 10);
            if ( checksum == 10 ) checksum = 0;

            //Utilizado a técnica de extração de método
            //return checksum == Integer.parseInt(valorSomenteNumeros.substring(12));

            return checksum == getParseInt(valorSomenteNumeros.substring(12));
        }
        catch (NumberFormatException nfe){
            return false;
        }
    }

    private int getParseInt(String valor) {
        return Integer.parseInt(valor);
    }
}
