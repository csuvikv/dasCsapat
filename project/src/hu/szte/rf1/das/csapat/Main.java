package hu.szte.rf1.das.csapat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.szte.rf1.das.csapat.controller.VidaCsardaController;
import hu.szte.rf1.das.csapat.model.bean.Pizza;


// Ezt az URL-t kell megadni, hogy ez az osztály fusson le
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VidaCsardaController c = new VidaCsardaController();   
	
	//delete this
	private static int i = 0;
	
    public Main() {
        super();
    }

    // Amikor betöltődik a /Main URL, ez a metódus fog lefutni
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//Feltöltöm az adatbázist adatokkal
		Pizza temp = new Pizza();
		
		temp.setName("FINOMPIZZA" + i);
		temp.setCost(848 + i);
		temp.setSize(50);
		temp.readIngredientsFromDataBase("Alma, Narancs, Banan");
		
		i++;
		
		c.addPizza(temp);
		
		// ----------------------------------------------------- //
		// Adat beállítása:
		request.setAttribute("egyediAzonosito", new String("valamilyen objektum"));
		
		List<String> pizzaList = new ArrayList<>();
		//Lekérem az adatokat
		for (Pizza p : c.listPizza()) {
			pizzaList.add(p.toString());
		}
		
		request.setAttribute("pizzaList", pizzaList);
		
		// Átpasszolom a vezérlést a Main.jsp-nek (bármi másnak is lehet)
		request.getRequestDispatcher("/View/Main.jsp").forward(request, response);
	}

	// HTTP GET/POST a különbség, általában ugyanaz mint a get..
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
