
public class Trojkat {
	
	private Punkt W1 ;
	private Punkt W2 ;
	private Punkt W3 ;
	
	Trojkat(Punkt P, Punkt Q, Punkt R){
		this.setW1(P);
		this.setW2(Q);
		this.setW3(R);
	}
	
	public Punkt getW1() {
		return W1;
	}
	public void setW1(Punkt w1) {
		W1 = w1;
	}
	public Punkt getW2() {
		return W2;
	}
	public void setW2(Punkt w2) {
		W2 = w2;
	}
	public Punkt getW3() {
		return W3;
	}
	public void setW3(Punkt w3) {
		W3 = w3;
	}
	
	private Obrys ObliczObrys(){

		int Xmin = 0;
		int Xmax = 0;
		int Ymin = 0;
		int Ymax = 0;
// obliczenie wartoœci maksymalnej na osi x		
		if (W1.getX()>W2.getX()){
			if (W1.getX()>W3.getX()){
				Xmax=W1.getX();
			} else Xmax=W3.getX();
		} else {
			if (W3.getX()>W2.getX()){
				Xmax=W3.getX();
			} else {
				Xmax=W2.getX();
			}
		}
		
// obliczenie wartoœci maksymalnej na osi x	
		
		if (W1.getX()<W2.getX()){
			if (W1.getX()<W3.getX()){
				Xmin=W1.getX();
			} else Xmin=W3.getX();
		} else {
			if (W3.getX()<W2.getX()){
				Xmin=W3.getX();
			} else {
				Xmin=W2.getX();
			}
		}	
		
		
		
// obliczenie wartoœci maksymalnej na osi y		
		if (W1.getY()>W2.getY()){
			if (W1.getY()>W3.getY()){
				Ymax=W1.getY();
			} else Ymax=W3.getY();
		} else {
			if (W3.getY()>W2.getY()){
				Ymax=W3.getY();
			} else {
				Ymax=W2.getY();
			}
		}
		
// obliczenie minimalnej wartoœci na osi y
		
		if (W1.getY()<W2.getY()){
			if (W1.getY()<W3.getY()){
				Ymin=W1.getY();
			} else Ymin=W3.getY();
		} else {
			if (W3.getY()<W2.getY()){
				Ymin=W3.getY();
			} else {
				Ymin=W2.getY();
			}
		}	
		return new Obrys(Xmin,Xmax,Ymin,Ymax);
		 
	}
	public String info(){
		String i;
		i="Mamy trójk¹t o wspó³rzêdnych P=(" + W1.getX() + "," + W1.getY() +") " + "Q=(" + W2.getX() + "," + W2.getY() +") " + "R=(" + W3.getX() + "," + W3.getY() + ") ";
		return i;
	}
	/*
	private boolean CzyNalezy(Punkt p) {
		boolean out = false;
		// g³ówna metoda programu - sprawdza czy punkt p nale¿y do trójk¹ta
		
		double a1,a2,a3,b1,b2,b3;
		double war1,war2,war3;
		
	 
		 a1=(double)(W2.getX() - W1.getX())/(double)(W2.getY() - W1.getY());
         a2=(double)(W3.getX() - W2.getX())/(double)(W3.getY() - W2.getY());    
         a3=(double)(W3.getX() - W1.getX())/(double)(W3.getY() - W1.getY());
         b1=(double)W1.getY()-(a1*(double)W1.getX());
         b2=(double)W2.getY()-(a2*(double)W2.getX());
         b3=(double)W3.getY()-(a3*(double)W3.getX());
		 
		 war1 = (a1 * (double)p.getX() -1.0 * (double)p.getY() + b1);
		 war2 = (a2 * (double)p.getX() -1.0 * (double)p.getY() + b2);
		 war3 = (a3 * (double)p.getX() -1.0 * (double)p.getY() + b3);
		 
		 if ( war1 > 0.0 && war2>0.0 && war3>0.0)
			 	out = true;
		 else
			 	out = false;
			 
		 
		 return out;
	}*/
	/*
	public int LiczbaPunktowWewnatrz() {
		int liczba=0;
		Obrys o;
		int ix=0,iy=0;
		Punkt p;
		
		o = this.ObliczObrys();
	
		for(ix=o.getXmin();ix<=o.getXmax();ix++) {
			for(iy=o.getYmin();iy<=o.getYmax();iy++) {
				p = new Punkt(ix,iy);
				if (this.CzyNalezy( p ))
					liczba++;
			}			
		}
		
		return liczba;
	}*/


private int NWD(int a,int b) {
    if (b == 0){ return a; }
     
    return NWD(b, (a % b));
}

public int LiczbaPunktowWewnatrzNWD() {
    int out;
    Obrys o = this.ObliczObrys();
    int j,k,a,b,h1,h2,h3;
    
    j = o.getXmax()-o.getXmin();
    k = o.getYmax()-o.getYmin();
    
    if (W1.getY()==o.getYmax())
        a = W1.getX() - o.getXmin();
    else
        if (W2.getY()==o.getYmax())
            a = W2.getX() - o.getXmin();
        else
            a = W3.getX() - o.getXmin();
    
    if (W1.getX()==o.getXmin())
        b = o.getYmax() - W1.getY();
    else
        if (W2.getX()==o.getXmin())
            b = o.getYmax() - W2.getY();
        else
            b = o.getYmax() - W3.getY();

    h1 = NWD(a,b) - 1;
    h2 = NWD(k, j-a) - 1;
    h3 = NWD(j, k-b) - 1;
    
    out = (j-1) * (k-1) - h1 - h2 - h3 - ((a-1)*(b-1)-h1)/2 - ((j-a-1)*(k-1)-h2)/2 - ((j-1)*(k-b-1)-h3)/2;
    
    return out;
	} 
}
