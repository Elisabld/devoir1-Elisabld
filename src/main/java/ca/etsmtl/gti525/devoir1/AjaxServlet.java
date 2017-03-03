 package ca.etsmtl.gti525.devoir1;

 import java.io.* ;
 import javax.servlet.* ;
 import javax.servlet.http.* ;

 public class AjaxServlet extends HttpServlet {
	 
	 private static final long serialVersionUID = -4865099303373864287L;

	 public AjaxServlet(){
		 
	 }
	 
	 
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException  {
		 
		 Collection collection = new Collection();

		 		 
		 if (request.getParameter("listeImages").isEmpty() and request.getParameter("listeImages") == "") {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		 }
		 
		 else {
			 if (request.getParameter("listeImages") == null){
			 	request.setAttribute("collection", collection.getImages());
			 	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/collection.jsp");
			 	dispatcher.forward(request, response);
			 }
			 else{
				Integer idPhoto = Integer.parseInt(request.getParameter("listeImages"));
				Photo photo = collection.getPhoto(idPhoto);

				response.setContentType("text/html");

				request.setAttribute("photo", photo);
				request.setAttribute("dossierVignettes", getServletConfig().getInitParameter("dossierVignettes"));

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.include(request, response);
			 }
		 }
			 
	}

	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException  {
	
		doGet(request, response) ;
	}
}

