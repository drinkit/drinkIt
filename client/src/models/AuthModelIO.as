package models
{
	import flash.display.Stage;
	import flash.external.ExternalInterface;
	
	import mx.controls.Alert;
	
	public class AuthModelIO implements IAuthModel
	{
		private static var _instance:AuthModelIO;
		
		public static function get instance():AuthModelIO
		{
			if (!_instance)
				_instance = new AuthModelIO(new PrivateConstructor());
			
			return _instance;
		}
		
		public function AuthModelIO(value:PrivateConstructor)
		{
		}
		
		public static const LOGIN_URLS:Object = {"google":"/oauth2/v1/userinfo"};
		
		public function init(stage:Stage):void
		{
			ExternalInterface.call("initOAuthIO");
			ExternalInterface.addCallback("onSocialLogin", onSocialLogin);
		}
		
		private function onSocialLogin(result:String):void
		{
			var userinfo:Object = JSON.parse(result);
			checkSocialUser(userinfo.email);
		}
		
		private function generateFakeSocialPassword():String
		{
			return "";
		}
		
		private function checkSocialUser(email:String):void
		{
			
		}
		
		public function login(provider:String, action:String):void
		{
			ExternalInterface.call("socialLogin", provider, action);
		}
	}
}

class PrivateConstructor
{
}
