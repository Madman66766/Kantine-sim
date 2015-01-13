public class PersoonsVergelijker
{
    public static void main(String[] args) {
        Persoon persoon1 = new Persoon("000000000", "Jan", "Visser", 8, 1, 1996, 'M');
        Persoon persoon2 = new Persoon("000000000", "Jan", "Visser", 8, 1, 1996, 'M');
        System.out.println(persoon1.equals(persoon2));
        System.out.println(persoon1 == persoon2);
    }
}