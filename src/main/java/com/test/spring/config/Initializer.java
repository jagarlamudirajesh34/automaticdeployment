package com.test.spring.config;

//tag::class[]
public class Initializer {
		// extends AbstractHttpSessionApplicationInitializer { // <1>

	/*public Initializer() {
		super(AppConfig.class); // <2>
	}
	
	@Override
	protected void afterSessionRepositoryFilter(ServletContext servletContext) {
		appendFilters(servletContext, new UserAccountsFilter());
	}*/
	
	/*@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
ctx.setServletContext(servletContext);

ServletRegistration.Dynamic servlet = servletContext.addServlet(
										"dispatcher", new DispatcherServlet(ctx));

servlet.setLoadOnStartup(1);
servlet.addMapping("/");
	}*/
}
//end::class[]