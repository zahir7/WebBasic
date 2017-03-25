var httpRequest=null;
	function getXmlHttpReqeust(){
		//explore 
		if(window.ActiveXObject){
			try{
				alert("msx2");
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					alert("micro");
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		}else if(window.XMLHttpRequest){
			
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}