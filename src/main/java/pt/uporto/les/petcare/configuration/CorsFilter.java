package pt.uporto.les.petcare.configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// origin
		String origin = httpRequest.getHeader("Origin");

		URL originUrl = null;
		try {
			originUrl = new URL(origin);
		} catch (MalformedURLException ex) {
		}

		// Handle only the HttpServletRequests the others block them for now
		if (request instanceof HttpServletRequest) {

			// Verify host
			if (originUrl != null) {
				httpResponse.addHeader("Access-Control-Allow-Origin", origin);
			} else {
				httpResponse.addHeader("Access-Control-Allow-Origin", "*");
			}

			httpResponse.addHeader("Access-Control-Allow-Credentials", "true");

			if ("OPTIONS".compareToIgnoreCase(httpRequest.getMethod()) == 0) {

				final String requestHeaderValue = "Access-Control-Request-Headers";

				httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
				httpResponse.setHeader("Access-Control-Max-Age", "3600");

				final String requestedHeaderValue = ((HttpServletRequest) request).getHeader(requestHeaderValue);
				httpResponse.setHeader("Access-Control-Allow-Headers", requestedHeaderValue);
				httpResponse.flushBuffer();

			} else {
				chain.doFilter(request, response);
			}
		}

	}
}
