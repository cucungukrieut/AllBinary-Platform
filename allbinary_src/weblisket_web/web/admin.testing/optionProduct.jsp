<%
/*
 *Copyright (c) 2002 All Binary
 *All Rights Reserved.
 *Don't Duplicate or Distributed.
 *Trade Secret Information
 *For Internal Use Only
 *Confidential
 *Unpublished
 *
 *Created By: Travis Berthelot
 *Date: 11/29/02
 *
 *
 *Modified By         When       ?
 *
 */
%>
<%@ page import="org.allbinary.business.user.inventory.item.option.BasicOptionItemData" %>
<HTML>
<HEAD>
<TITLE>Option Product Creation - Store Admin</TITLE>

<%@ include file="globals.jsp" %>
<%@ include file="javascript.jsp" %>
<%@ include file="css.jsp" %>
</HEAD>
<BODY bgcolor=<%= BACKGROUNDCOLOR %> >
<%@ include file="header.jsp" %>
<%@ include file="storeTopBar.jsp" %>
<%@ include file="storeTopBar2.jsp" %>
<%
String ADDPRODUCT = "Add Product";

Vector roles = new Vector();
roles.add(BasicUserRole.ADMINISTRATOR);
roles.add(BasicUserRole.STOREMANAGER);
roles.add(BasicUserRole.PRODUCTMANAGER);

String ADD_OPTION_WITH_JAVASCRIPT = "AddOption";
String ADD_PRODUCT_WITH_JAVASCRIPT = "AddProduct";
String OPTION_SELECTION_JAVASCRIPT = "RemoveOption";
%>
<ecommerce:authentication 
   command="<%= GLOBALS.PROCESSBODYIFNOTAUTHENTICATED %>" 
   roles="<%= roles %>" >
<jsp:forward page="<%= LOGOUTPAGE %>" />
</ecommerce:authentication>

<div class="mainHeading">
<p><%= storeName %> - Basic Option Product Creation - <a href="<%= STOREADMINFREEBLISKETONLINEHELP + BASICOPTIONPRODUCTPAGE %>">Help</a></p>
<div class="main">

<%
   String product = request.getParameter("PRODUCT");

   if(product!=null && storeName!=null)
   {
      if(product.compareTo("ACTIONCOMPLETE")==0)
      {
%>
<form method="POST" action="<%= ADDPRODUCTPAGE %>">
<br><input class="submit" type="submit" value="Add Different Type Of Product" name="<%= GLOBALS.ADMINCOMMAND %>">
</form>
<form method="POST" action="<%= CATEGORYSELECTIONPAGE %>">
<br><input class="submit" type="submit" value="Add Product With A Different Category" name="<%= GLOBALS.ADMINCOMMAND %>">
</form>

<p>
<ecommerce:inventory isSelected="true" 
   command="<%= GLOBALS.INSERT %>" 
   storeName="<%= storeName %>"
/>
</p>

<%
      }
   }
%>
* = Required Fields<br>

<form method="POST" action="<%= OPTIONPRODUCTACTIONPAGE %>" enctype="multipart/form-data" >
<input type="hidden" name="<%= BasicItemData.NUMBER %>" size="11" value="0" >
<input type="hidden" name="<%= BasicItemData.WEIGHT %>" size="11" value="0" >
<input type="hidden" name="<%= BasicItemData.INBASKETS %>" size="11" value="0">
<input type="hidden" name="<%= BasicItemData.NEWORUSED %>" size="11" value="New">
<input type="hidden" name="<%= BasicItemData.CUSTOMS %>" size="50" value="0" >
<input type="hidden" name="<%= BasicItemData.DOWNLOADS %>" size="50" value="1" >
<input type="hidden" name="<%= BasicItemData.GROUPS %>" size="50" value="0" >
<input type="hidden" name="<%= BasicItemData.OPTIONS %>" size="50" value="0" >
<input type="hidden" name="<%= BasicItemData.PERMISSIONS %>" size="50" value="0" >
<input type="hidden" name="<%= BasicItemData.SPECIALS %>" size="50" value="0" >

<p>
<table class="main" border="0" cellpadding="2" cellspacing="2" style="border-collapse: collapse" bordercolor="#111111" width="550" >
   <tr>
      <td width="51%" valign="top" >*Enabled:</td>
      <td width="49%"><SELECT name='<%= EntryData.ENABLE %>' >
                         <OPTION>Yes</OPTION>
                         <OPTION>No</OPTION>
                      </SELECT>
      </td>
   </tr>
   <tr>
      <td width="51%" valign="top" >*Unique ID:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.ID %>" size="18" value='<%= new allbinary.helpers.generators.ProductIdGenerator().getNext() %>' ></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >*Price:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.PRICE %>" size="18"></td>
   </tr> 
   <tr>
      <td width="51%" valign="top" >*Summary:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.SUMMARY %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >*Description:</td>
      <td width="49%"><textarea name="<%= BasicItemData.DESCRIPTION %>" rows="10" cols="48" wrap="virtual" ></textarea></td>
   </tr>
   <tr>
      <td width="51%" valign="top" >*Keywords:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.KEYWORDS %>" size="50"></td>
   </tr>
   <tr>
      <td width="51%" valign="top" >*Category:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.CATEGORY %>" size="50" value="<%= category %>"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >*Type:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.TYPE %>" size="50"></td>   
   </tr>

   <tr>
      <td width="51%" valign="top" >*Option Title:</td>
      <td width="49%"><input type="text" name="<%= BasicOptionItemData.OPTION_ONE_TITLE %>" size="50"></td>   
   </tr>   
</table>
<br>
<p>Enter a option and match it with the Basic Product of your choice.  Then use the add command to add the new options.</p>

<table class="main" border="0" cellpadding="2" cellspacing="2" style="border-collapse: collapse" bordercolor="#111111" width="550" >
   <tr>
      <td width="51%" valign="top" >*New Option:</td>
      <td width="49%">
         <input id="<%= ADD_OPTION_WITH_JAVASCRIPT %>" onBlur="setNewOptionValue(this.value);" type="text" name="<%= ADD_OPTION_WITH_JAVASCRIPT %>" size="50" >
      </td>
   </tr>   
   <tr>   
      <td width="51%" valign="top" >*Product ID+Summary:</td>
      <td width="49%">
         <input id="<%= ADD_PRODUCT_WITH_JAVASCRIPT %>" onBlur="setProduct(this.value);" type="text" name="<%= ADD_OPTION_WITH_JAVASCRIPT %>" size="50" >
      </td>   
   </tr>   
</table>

<table class="main" border="0" cellpadding="2" cellspacing="2" style="border-collapse: collapse" bordercolor="#111111" width="550" >
   <tr>
      <td width="51%" valign="top" >
         <A class="cloak" HREF="javascript:addOption('options');"  >
            <div ID="add" class="menuItems"
               onMouseOver="changeBackgroundColor('add','<%= BUTTONOVERCOLOR %>');return true;"
               onMouseOut="changeBackgroundColor('add','<%= BUTTONCOLOR %>');return true;" >
               Add
            </div>
         </A>
         <A class="cloak" HREF="javascript:removeSelectedOption('options');"  >
            <div ID="remove" class="menuItems"
               onMouseOver="changeBackgroundColor('remove','<%= BUTTONOVERCOLOR %>');return true;"
               onMouseOut="changeBackgroundColor('remove','<%= BUTTONCOLOR %>');return true;" >
               Remove
            </div>
         </A>
         <A class="cloak" HREF="javascript:clearOptions('options');"  >
            <div ID="clear" class="menuItems"
               onMouseOver="changeBackgroundColor('clear','<%= BUTTONOVERCOLOR %>');return true;"
               onMouseOut="changeBackgroundColor('clear','<%= BUTTONCOLOR %>');return true;" >
               Clear
            </div>
         </A>
         Max 10 Options:
      </td>   
      <td width="49%">
         <SELECT id="options" size="5" >
         </SELECT>
      </td>
   </tr>
</table>
</p>

Supported Image Types Include: <%= fileTypesBuffer.toString() %><br><br>
<table class="main" border="0" cellpadding="2" cellspacing="2" style="border-collapse: collapse" bordercolor="#111111" width="550" >
   <tr>
      <td width="51%" valign="top" >Image:</td>
      <td width="49%"><input type="file" name="<%= BasicItemData.IMAGE %>" size="37"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >Distributor:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.DISTRIBUTOR %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >ID Used By Distributor:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.IDUSEDBYDISTRIBUTOR %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >Produced By:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.PRODUCEDBY %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >Production Date:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.PRODUCTIONDATE %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >First Production Date:</td>
      <td width="49%"><input type="text" name="<%= BasicItemData.STARTPRODUCTIONDATE %>" size="50"></td>   
   </tr>
   <tr>
      <td width="51%" valign="top" >Comment:</td>
      <td width="49%"><textarea name="<%= BasicItemData.COMMENT %>" rows="10" cols="48" wrap="virtual" ></textarea></td>
   </tr>
</table>

<br><input class="submit" type="submit" value="<%= ADDPRODUCT %>" name="<%= GLOBALS.ADMINCOMMAND %>">
</form>
<%@ include file="copyright.jsp" %>
</div>
</div>

</BODY>
</HTML>