package com.dev.chicagotraintracker;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
 
public class ExampleHandler extends DefaultHandler{
 
        // ===========================================================
        // Fields
        // ===========================================================
        
        private boolean in_eta = false;
        private boolean in_staNm = false;
        private boolean in_rt = false;
        private boolean in_ctaat = false;
      
        
        public ParsedExampleDataSet myParsedExampleDataSet = new ParsedExampleDataSet();
 
        // ===========================================================
        // Getter & Setter
        // ===========================================================
 
        public ParsedExampleDataSet getParsedData() {
                return this.myParsedExampleDataSet;
        }
 
        // ===========================================================
        // Methods
        // ===========================================================
        @Override
        public void startDocument() throws SAXException {
                this.myParsedExampleDataSet = new ParsedExampleDataSet();
        }
        
        
 
        @Override
        public void endDocument() throws SAXException {
                // Nothing to do
        }
 
        /** Gets be called on opening tags like: 
         * <tag> 
         * Can provide attribute(s), when xml was like:
         * <tag attribute="attributeValue">*/
        @Override
        public void startElement(String namespaceURI, String localName,
                        String qName, Attributes atts) throws SAXException {
        	if (localName.equals("ctaat"))
        		if (localName.equals("eta")) {
                        if (localName.equals("rt")) {
                        	 
                            if(this.in_staNm)
                  
                                myParsedExampleDataSet.setStaNm(atts.getValue("displayname"));
                            if (localName.equals("staNm")) {         
                            if(this.in_rt){
                            	myParsedExampleDataSet.setrt(atts.getValue("displayname"));
                            }
                  
                  
                            }
                        }
                        }
        }
        
        /** Gets be called on closing tags like: 
         * </tag> */
        @Override
        public void endElement(String namespaceURI, String localName, String qName)
                        throws SAXException {
        		if (localName.equals("staNm")) {
                        this.in_staNm = false;
        		}else if (localName.equals("ctaat")) {
                        this.in_ctaat = false; 
                }else if (localName.equals("rt")) {
                        this.in_rt = false;
                }else if (localName.equals("rn")) {
                        // Nothing to do here
                }
        }
        
        /** Gets be called on the following structure: 
         * <tag>characters</tag> */
        @Override
    public void characters(char ch[], int start, int length) {
        	
        	if(this.in_ctaat)
        	
            if(this.in_eta) {
            	 
 
                if(this.in_rt){
 
                    myParsedExampleDataSet.setrt(new String(ch, start, length));
                if (this.in_staNm){
                	myParsedExampleDataSet.setStaNm(new String(ch, start, length));
                }
    }
}
        }
}
