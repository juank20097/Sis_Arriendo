package arriendo.manager;

import java.util.Date;
import java.util.List;

import arriendo.entidades.ARR_Contratos_Det;

public class Test {

	public static void main(String[] args) {
		HibernateDAO h = new HibernateDAO();
		String valorSitio="s1";
		Date cab_fechaini = new Date("25/09/2015");
		Date cab_fechafin = new Date("27/09/2015");
		int u=0;
		List<ARR_Contratos_Det> g = h.findWhere(ARR_Contratos_Det.class, "det_estado='F' AND o.sit.sit_nombre='"+valorSitio+"'", "det_id");
		//System.out.println(g.size());
		for (ARR_Contratos_Det c : g) {
			//PROCESO A FINALIZAR VALIDACION
			//System.out.println(c.getDet_id());
			if (
					(cab_fechaini.after(c.getCon_cab().getCab_fechaini()) 
					&& cab_fechaini.before(c.getCon_cab().getCab_fechafin()))
					|| (cab_fechafin.after(c.getCon_cab().getCab_fechaini()) 
							&& cab_fechafin.before(c.getCon_cab().getCab_fechafin()))
					
								){
				System.out.println("1000");
				u=1000;
			}else{
				System.out.println("suma");
				u++;
			}
		}
		System.out.println(" Valor "+u);
	}

}

