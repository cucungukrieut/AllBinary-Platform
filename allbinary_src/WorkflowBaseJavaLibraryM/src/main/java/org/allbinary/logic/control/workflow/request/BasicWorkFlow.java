/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.logic.control.workflow.request;

import org.allbinary.data.tree.dom.document.DomDocumentHelper;
import org.allbinary.logic.basic.string.StringUtil;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.business.context.modules.storefront.StoreFrontData;
import org.allbinary.data.tree.dom.ModDomHelper;
import org.allbinary.logic.communication.http.request.RequestParams;
import org.allbinary.logic.communication.http.request.session.WeblisketSession;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.servlet.jsp.PageContext;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.allbinary.business.entry.EntryData;
import org.allbinary.logic.control.workflow.WorkFlowData;

/*
 *This basic workflow is the workflow representation for the workflow Dom
 *in a workflow entry.
 *
 */
public class BasicWorkFlow 
{
   private Document workFlowDoc;
   private String workFlowName;
   private String storeName;   
   
   //create a new empty workflow
   public BasicWorkFlow()
   {
      this.workFlowName = StringUtil.getInstance().EMPTY_STRING;
      this.workFlowDoc = DomDocumentHelper.create();
      Node workFlowNode = this.workFlowDoc.createElement(WorkFlowData.getInstance().WORKFLOW);
      this.workFlowDoc.appendChild(workFlowNode);
   }

   //Create a storefront workflow as commanded by store manager
   //The hashMap argument contains tag properties that may override or set properties
   //not specified in throws request
   
   //used for creating or updating a workflow
   public BasicWorkFlow(HashMap hashMap, PageContext pageContext) throws Exception
   {
      WeblisketSession weblisketSession = 
         new WeblisketSession(hashMap, pageContext);

      this.storeName = weblisketSession.getStoreName();

      HashMap requestHashMap = new RequestParams(pageContext).toHashMap();

      this.workFlowName = (String) requestHashMap.get(
    		  WorkFlowData.getInstance().NAME);
      
      this.workFlowDoc = DomDocumentHelper.create(
    		  (String) requestHashMap.get(WorkFlowData.getInstance().DATA));
   }

   //Create a workflow from the database
   //Used by user request and for validating a delete, edit, and/or view
   public BasicWorkFlow(HashMap hashMap) throws Exception   
   {
      this.workFlowName = (String) hashMap.get(WorkFlowData.getInstance().NAME);
      this.storeName =  (String) hashMap.get(StoreFrontData.getInstance().NAME);
      this.workFlowDoc =
      DomDocumentHelper.create((String) hashMap.get(WorkFlowData.getInstance().DATA));
   }

   public String getName()
   {
      return this.workFlowName;
   }

   public String getStoreName()
   {
      return this.storeName;
   }
   
   /*
   public  process()
   {
      try
      {
         //BasicWorkFlow
         return "Name: " + workFlowName + "<br />Data: " + DomHelper.toString(this.workFlowDoc);
      }
      catch(Exception e)
      {
         String error = "Failed to process workflow";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
         {
            LogUtil.put(error,this,"process()",e);
         }
         return null;
      }
   }
*/
   
   public Object getKey()
   {
      return (Object) this.getName();
   }
   
   public Vector toVector() throws Exception
   {
      Vector values = new Vector();
      
      values.add(this.workFlowName);
      values.add(this.storeName);
      values.add(DomDocumentHelper.toString(this.workFlowDoc));

      Calendar calendar=Calendar.getInstance();
      String time = new String(new Long(calendar.getTimeInMillis()).toString());
      values.add(time);
      values.add(time);

      return values;
   }

   public HashMap toHashMap() throws Exception
   {
      HashMap hashMap = new HashMap();

      hashMap.put(WorkFlowData.getInstance().NAME, this.workFlowName);
      hashMap.put(StoreFrontData.getInstance().NAME, this.storeName);
      hashMap.put(WorkFlowData.getInstance().DATA, DomDocumentHelper.toString(this.workFlowDoc));
      
      Calendar calendar=Calendar.getInstance();
      String time = new String(new Long(calendar.getTimeInMillis()).toString());
      hashMap.put(EntryData.getInstance().LASTMODIFIED, time);
      
      return hashMap;
   }
   
   //This returns a node for the view and not the
   public Node toXmlNode(Document document) //throws Exception
   {
      try
      {
         HashMap hashMap = this.toHashMap();
         Set keySet = hashMap.keySet();
         Iterator iterSet = keySet.iterator();
         
         Node node = document.createElement(WorkFlowData.getInstance().WORKFLOW);
         
         while(iterSet.hasNext())
         {
            String name = (String) iterSet.next();
            String value = (String) hashMap.get(name);
            
            node.appendChild(ModDomHelper.createNameValueNodes(document, name, value));
         }
         
         return node;
         //return this.workFlowDoc.getFirstChild();
      }
      catch(Exception e)
      {
         String error = "Failed to get node";
         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
         {
            LogUtil.put(LogFactory.getInstance(error, this, "toXmlNode()", e));
         }
         return null;
      }
   }
   
   public Document toXmlDoc()
   {
      try
      {
         return this.workFlowDoc;
      }
      catch(Exception e)
      {
         String error = "Failed to get Doc";
         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
         {
            LogUtil.put(LogFactory.getInstance(error,this,"toXmlDoc()",e));
         }
         return null;
      }
   }
   
   /*
   public String view()
   {
      try
      {
         return "";
      }
      catch(Exception e)
      {
         String error = "Failed to view WorkFlow";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.TAGHELPERERROR))
         {
            LogUtil.put(error,this,"view()",e);
         }
         return error;
      }
   }
   */
   
   public Boolean isValid()
   {
      try
      {
         Boolean returnBoolean = Boolean.TRUE;
         
         if(this.workFlowName == null)
         {
            returnBoolean = Boolean.FALSE;
         }
         
         return returnBoolean;
      }
      catch(Exception e)
      {
         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.SQLTAGSERROR))
         {
            LogUtil.put(LogFactory.getInstance("Failed to validate",this,"isValid()",e));
         }
         return Boolean.FALSE;
      }
   }
   
   public String validationInfo()
   {
      try
      {
         StringBuffer stringBuffer = new StringBuffer();
         
         if(this.workFlowName==null) stringBuffer.append("No WorkFlow name specified.");
         
         return stringBuffer.toString();
      }
      catch(Exception e)
      {
         if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.VIEWERROR))
         {
            LogUtil.put(LogFactory.getInstance("Failed to generate validation error info",this,"validationInfo()",e));
         }
         return "Error Getting Validation Info";
      }
   }
   
   public Document toValidationInfoDoc()
   {
      return null;
   }
   
   public Node toValidationInfoNode(Document document)
   {
      return null;
   }
}
