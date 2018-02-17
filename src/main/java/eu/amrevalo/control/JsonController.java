/*
 * Copyright (c) 2017-2018 
 *
 * by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com) & DAW students
 * 
 * GESANE: Free Open Source Health Management System
 *
 * Sources at:
 *                            https://github.com/rafaelaznar/gesane-server
 *                            https://github.com/rafaelaznar/gesane-client
 *                            https://github.com/rafaelaznar/gesane-database
 *
 * GESANE is distributed under the MIT License (MIT)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.amrevalo.control;

import eu.amrevalo.bean.helper.ReplyBeanHelper;
import eu.amrevalo.connection.publicinterface.ConnectionInterface;
import eu.amrevalo.factory.ConnectionFactory;
import eu.amrevalo.helper.constant.ConnectionConstants;
import eu.amrevalo.helper.constant.ConfigurationConstants;
import eu.amrevalo.helper.Log4jHelper;
import eu.amrevalo.factory.ServiceFactory;
import eu.amrevalo.helper.EnumHelper.Environment;
import static eu.amrevalo.helper.ParameterHelper.prepareCamelCaseObject;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class JsonController extends HttpServlet {

    private void Controllerdelay(Integer iLast) {
        try {
            if (iLast > 0) {
                Thread.sleep(iLast);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        //response.setHeader("Access-Control-Allow-Methods", "PATCH, POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type");

        ////////////////////////////////
        response.setContentType("text/html;charset=UTF-8");
        String name = "";

        //if (ServletFileUpload.isMultipartContent(request)) {
        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    name = new File(item.getName()).getName();
                    //item.write(new File(".//..//webapps//images//" + name));
                    item.write(new File(".//..//webapps//images//" + name));
                } else {
                }

            }

        } catch (Exception ex) {

        }
        //}
////////////////////////////

        ReplyBeanHelper oReplyBean = null;
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception ex) {
                oReplyBean = new ReplyBeanHelper(500, "Database Connection Error: Please contact your administrator");
            }
            if (ConfigurationConstants.environment == Environment.Debug) {
                Controllerdelay(ConfigurationConstants.programDalay);
            }
            String ob = prepareCamelCaseObject(request);
            String op = request.getParameter("op");
            if (("".equalsIgnoreCase(ob) && "".equalsIgnoreCase(op)) || (ob == null && op == null)) {
                Connection oConnection = null;
                ConnectionInterface oPooledConnection = null;
                response.setContentType("text/html;charset=UTF-8");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>TIENDA ALBERTO server</title><link rel=\"shortcut icon\" href=\"favicont.ico\" type=\"image/x-icon\"></head>");
                out.println("<body style=\"background: url(tiendafondo.jpg) no-repeat center center fixed; background-repeat: no-repeat;background-size: 900px;\">");
                out.println("<h1>Welcome to TIENDA ALBERTO server</h1><h2>Servlet controller json listening at " + InetAddress.getLocalHost().getHostAddress() + ":" + request.getLocalPort() + request.getContextPath() + "</h2>");
                out.println("version: " + ConfigurationConstants.version + " (" + ConfigurationConstants.versionDate + ")" + "<br>");
                out.println("author: " + ConfigurationConstants.author + " (" + ConfigurationConstants.authorMail + ") " + "<br>");
                out.println("license: " + ConfigurationConstants.licenseLink + "<br>");
                out.println("sources: " + ConfigurationConstants.sources + "<br>");
////
                try {
                    oPooledConnection = ConnectionFactory.getSourceConnection(ConnectionConstants.connectionName);
                    oConnection = oPooledConnection.newConnection();
                    out.print("<h3>Database Connection OK</h3>");

                } catch (Exception ex) {
                    out.print("<h3>Database Conexión KO</h3>");
                } finally {
                    out.println("</body>");
                    out.println("</html>");
                    if (oConnection != null) {
                        oConnection.close();
                    }
                    if (oPooledConnection != null) {
                        oPooledConnection.disposeConnection();
                    }
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
                response.setHeader("Access-Control-Allow-Methods", "GET,POST");
                response.setHeader("Access-Control-Max-Age", "86400");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type");
                try {
                    oReplyBean = (ReplyBeanHelper) ServiceFactory.executeMethodService(request);
                } catch (Exception ex) {
                    if (ConfigurationConstants.environment == Environment.Debug) {
                        out.println(ex);
                        ex.printStackTrace(out);
                    } else {
                        oReplyBean = new ReplyBeanHelper(500, "trolleyes-server error. Please, contact your administrator.");
                    }
                    Log4jHelper.errorLog(this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName(), ex);
                    oReplyBean = new ReplyBeanHelper(500, "Object or Operation not found : Please contact your administrator");
                }
                response.setStatus(oReplyBean.getCode());
                out.print("{\"status\":" + oReplyBean.getCode() + ", \"json\":" + oReplyBean.getJson() + "}");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(JsonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(JsonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
