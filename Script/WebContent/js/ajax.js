var httpRequest=null;
	function getXmlHttpReqeust(){
		
		if(window.ActiveXObject){
			try{
				
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		}else if(window.XMLHttpRequest){
			alert("표준 브라우저 입니다.");
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}