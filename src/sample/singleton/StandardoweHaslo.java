package sample.singleton;


public class StandardoweHaslo {
    private  static StandardoweHaslo insHaslo = null;

    public int dlugoscWyrazu = 4;


    public static StandardoweHaslo getInsHaslo()
    {
        if (insHaslo == null)
            insHaslo = new StandardoweHaslo();
        return insHaslo;
    }
    private StandardoweHaslo(){
        System.out.println("stworzono");


    }
}
