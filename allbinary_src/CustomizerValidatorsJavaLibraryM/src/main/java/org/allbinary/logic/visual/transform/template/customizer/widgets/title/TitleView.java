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
package org.allbinary.logic.visual.transform.template.customizer.widgets.title;

import org.allbinary.data.tree.dom.DomNodeHelper;
import org.allbinary.data.tree.dom.DomSearchHelper;
import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.data.tree.dom.DomData;
import org.allbinary.data.tree.dom.DomNodeInterface;
import org.allbinary.data.tree.dom.ModDomHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.HashMap;
import org.allbinary.logic.basic.string.StringValidationUtil;

public class TitleView implements DomNodeInterface
{   
   private String title;

   private static final String NAME = "None";
   
   public TitleView()
   {
	   this.title = NAME;
   }

   public TitleView(Node node) throws Exception
   {
      Node titleTextNode = 
         DomSearchHelper.getNode(
            TitleData.getInstance().TEXT, 
            node.getChildNodes());

      Node valueNode =
         DomSearchHelper.getNode(
            DomData.VALUE,
            titleTextNode.getChildNodes());
      
      this.title = DomNodeHelper.getTextNodeValue(valueNode);
      
      if(StringValidationUtil.getInstance().isEmpty(this.title))
      {
    	  this.title = NAME;
      }

      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.VIEW))
      {
         LogUtil.put(LogFactory.getInstance("Title: " + this.getTitle(), this, "Consructor()"));
      }
   }

   public TitleView(HashMap hashMap)
   {
      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.VIEW))
      {
         LogUtil.put(LogFactory.getInstance("HashMap: " + hashMap.toString(), this, "Constructor()"));
      }
      
      this.getFormData(hashMap);      
   }

   public String getTitle()
   {
      return this.title;
   }
      
   public void getFormData(HashMap hashMap)
   {
      this.title = (String) hashMap.get(TitleData.getInstance().TEXT);
      
      if(StringValidationUtil.getInstance().isEmpty(this.title))
      {
    	  this.title = NAME;
      }
   }
   
   public HashMap toHashMap()
   {
      HashMap hashMap = new HashMap();
      hashMap.put(TitleData.getInstance().TEXT, this.getTitle());
      return hashMap;
   }

   public Node toXmlNode(Document document) throws Exception
   {
      HashMap hashMap = this.toHashMap();

      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigType.VIEW))
      {
         LogUtil.put(LogFactory.getInstance("TitleView HashMap: " + hashMap.toString(), this, "toXmlNode()"));
      }

      return ModDomHelper.createNameValueNodes(document, TitleData.getInstance().NAME, hashMap);
   }
}