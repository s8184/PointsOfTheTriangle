
public class TrojkatMain {

	public static void main(String[] args) {
		Punkt P1=new Punkt(3,2);
		Punkt P2=new Punkt(7,6);
		Punkt P3=new Punkt(6,1);
		int liczba=0;
		
		
		Trojkat t=new Trojkat(P1,P2,P3);
		liczba = t.LiczbaPunktowWewnatrz();
		
		System.out.println(t.info());
		System.out.println("Liczba punkt�w wewn�trz tr�jk�ta (nie licz�c punkt�w na bokach): "+liczba);
		}
	}


