
package com.revature.soap_server;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.3
 * 2017-01-10T14:18:22.731-05:00
 * Generated source version: 3.1.3
 * 
 */
public final class HelloWorld_HelloWorldImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://soap_server.revature.com/", "HelloWorldImplService");

    private HelloWorld_HelloWorldImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HelloWorldImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        HelloWorldImplService ss = new HelloWorldImplService(wsdlURL, SERVICE_NAME);
        HelloWorld port = ss.getHelloWorldImplPort();  
        
        {
        System.out.println("Invoking sayHi...");
        java.lang.String _sayHi_arg0 = "";
        java.lang.String _sayHi__return = port.sayHi(_sayHi_arg0);
        System.out.println("sayHi.result=" + _sayHi__return);


        }
        {
        System.out.println("Invoking work...");
        port.work();


        }

        System.exit(0);
    }

}
