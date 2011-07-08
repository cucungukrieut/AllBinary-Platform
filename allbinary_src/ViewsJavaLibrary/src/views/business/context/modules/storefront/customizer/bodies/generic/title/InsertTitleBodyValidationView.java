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
package views.business.context.modules.storefront.customizer.bodies.generic.title;

import abcs.logic.communication.log.LogFactory;
import java.util.HashMap;

import org.w3c.dom.Node;
import org.w3c.dom.Document;

import allbinary.logic.communication.http.request.RequestParams;

import allbinary.data.tree.dom.DomNodeInterface;

import allbinary.logic.visual.transform.info.TransformInfoInterface;

import allbinary.logic.control.validate.ValidationComponentInterface;

import allbinary.logic.visual.transform.template.customizer.bodies.title.TitleBodyValidation;

import abcs.logic.communication.log.LogUtil;

import views.business.context.modules.storefront.customizer.CustomizerUtil;
import views.business.context.modules.storefront.customizer.StoreCustomizerComponentUtil;

public class InsertTitleBodyValidationView extends TitleBodyCustomizerView implements ValidationComponentInterface
{
   public InsertTitleBodyValidationView(TransformInfoInterface transformInfoInterface) throws Exception
   {
      super(transformInfoInterface);
      
      HashMap requestHashMap =
      new RequestParams(this.getPageContext()).toHashMap();
      
      this.titleBody = new TitleBodyValidation(requestHashMap);
   }


    public Document toXmlDoc() throws Exception
    {
        return null;
    }

   public Boolean isValid()
   {
      try
      {
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.VIEW))
         {
            LogUtil.put(LogFactory.getInstance("Started Validation",this,"isValid()"));
         }
         
         Boolean isValid = this.titleBody.isValid();
         
         if(isValid == Boolean.TRUE)
         {
            //Insert XML into the view specified by the Object Config for this view
            CustomizerUtil.insert(
            this.getTransformInfoInterface(),
            (DomNodeInterface) this.titleBody);
         }
         
         return isValid;
      }
      catch(Exception e)
      {
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.VIEWERROR))
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
         
         stringBuffer.append(this.titleBody.validationInfo());
         
         return stringBuffer.toString();
      }
      catch(Exception e)
      {
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.VIEWERROR))
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
   
   public String view() throws Exception
   {
      try
      {
         return StoreCustomizerComponentUtil.generate(this.getTransformInfoInterface());
      }
      catch(Exception e)
      {
         String error = "Failed to view";
         if(abcs.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(abcs.logic.communication.log.config.type.LogConfigType.TAGHELPERERROR))
         {
            LogUtil.put(LogFactory.getInstance(error,this,"view()",e));
         }
         throw e;
      }
   }
}
