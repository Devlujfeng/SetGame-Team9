var source;
var h=0;
$(function() {
    var goodTemplate = Handlebars.compile($( "#resultTemplate" ).html()); 
    $.getJSON('SendCardServlet').done(function(result){
     console.log("testforJS");
     var l = JSON.stringify(result);
     console.log(l);
     var m=JSON.parse(l);
     for (var i=0;i<m.length;i++)
     {
      document.getElementById("img"+i).setAttribute("src","img/"+m[i].CardsNo+".gif")     
     }
      

  
});
//$("#newgame").on("click",function(){
//      
//
//    $.getJSON('SendCardServlet').done(function(result){
//     console.log("testforJS");
//     var l = JSON.stringify(result);
//     console.log(l);
//     var m=JSON.parse(l);
//     for (var i=0;i<m.length;i++)
//     {
//      document.getElementById("img"+i).setAttribute("src","img/"+m[i].CardsNo+".gif")     
//     }
//     
//     var choicear = document.getElementsByName("choice"); 
//      for(var i=0;i<choicear.length;i++) 
//     {
//      if(choicear[i].type=="checkbox")
//      choicear[i].checked==flase;
//     }
//  
//}); 
//
//});

$("#dochk").on("click",function(){
    $.getJSON("IsSetServlet",{
         c1:$("#a").val(),
         c2:$("#b").val(),
         c3:$("#c").val()
     }).done(function(result)
    {
     
     var l=JSON.stringify(result);
     var m=JSON.parse(l);
     console.log(m);
     
      var flag=m['flag'];
     var data={
    m0:"img/"+m['card1']+".gif",
    m1:"img/"+m['card2']+".gif",
    m2:"img/"+m['card3']+".gif"   
};
     
     console.log(flag);
if(flag=="1")
{alert('Congratulations! This is a set!'); 
 $("#resultSet").append(goodTemplate(data)); }
else if(flag=="2")
{alert('Sorry!This is not a set!');  }
});
   
});



$("#findset").on("click",function(){

      $.getJSON('FindSetServlet').done(function(result){
     console.log("testforJS");
     var l = JSON.stringify(result);
     console.log(l);
     var m=JSON.parse(l);
     if(m[h]!=null)
     {
     alert('try this'+m[h].findset);
     h++;
     }
     else
     {alert('There is no set ,please restart games');}
     
//     for (var i=0;i<m.length;i++)
//     {
//      document.getElementById("img"+i).setAttribute("src","img/"+m[i].CardsNo+".gif")     
//     }
        
  
}); 
});
//
//var data={
//    m0:"img/"+t[0].card1+".gif",
//    m1:"img/"+t[0].card2+".gif",
//    m2:"img/"+t[0].card3+".gif"   
//};
//$("#resuledemo").append(goodTemplate(data));
});