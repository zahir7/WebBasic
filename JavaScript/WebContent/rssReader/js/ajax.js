
//XMLHttpRequest ��ü�� ������ JavaScript
var httpRequest=null;
//Explore ������ ���� Ȯ���ϴ� �÷��װ� �α�
var isExplore=true;
	function getXmlHttpReqeust(){
		
		//������ �� ������ �迭�϶�
		if(window.ActiveXObject){
			isExplore=true;
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e2){
					return null;
				}
			}
		//�������� ǥ�� �迭�϶�
		}else if(window.XMLHttpRequest){
			isExplore=false;
			return new XMLHttpRequest();
		}else{
			return null;
		}
	}