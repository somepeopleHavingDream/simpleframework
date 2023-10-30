<!DOCTYPE html>
<html>
<head data-suburl="">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	
		<meta name="author" content="coding-420" />
		<meta name="description" content="simpleframework - 自研框架以及相关的demo" />
		<meta name="keywords" content="慕课网Git,代码托管,Git,Git代码托管,实战课源码">
	
	<meta name="referrer" content="no-referrer-when-downgrade" />
	<meta name="_csrf" content="9ICn-VkX_1TQ9an7D0RmWRK7Yps6MTY5ODY3MjkwMzA0MTM4OTE1Mw==" />
	<meta name="_suburl" content="" />
	
	
	
		<meta property="og:url" content="https://git.imooc.com/coding-420/simpleframework" />
		<meta property="og:type" content="object" />
		<meta property="og:title" content="coding-420/simpleframework">
		<meta property="og:description" content="自研框架以及相关的demo">
		<meta property="og:image" content="https://git.imooc.com/img/avatar_default.png" />
	
	
	<link rel="shortcut icon" href="/img/favicon.ico" />

	<script src="/js/jquery.min.js"></script>
	<script src="/js/libs/jquery.are-you-sure.js"></script>
	<link rel="stylesheet" href="/assets/font-awesome-4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/font-imooc/css/font-less.css">
	<link rel="stylesheet" href="/assets/font-imv2/css/style.css">
	<link rel="stylesheet" href="/assets/octicons-4.3.0/octicons.min.css">
	<link rel="stylesheet" href="/js/libs/moco/v1.0/dist/css/moco.min.css?v=1">
	
	

	

	
	<link rel="stylesheet" href="/css/semantic-2.2.13.min.css">
	<link rel="stylesheet" href="/css/gogs.css?v=ffd58de614cbac9361a58ea879831fad">
	<link rel="stylesheet" href="/css/profie.css?v=ffd58de614cbac9361a58ea879831fad">
	
	<script src="/js/semantic-2.2.13.min.js"></script>
	<script src="/js/gogs.js?v=ffd58de614cbac9361a58ea879831fad1"></script>
	<script src="/js/libs/moco/v1.0/dist/js/moco.min.js?v=1"></script>

	
	<script type = "text/javascript">
	(function() {
		window.zhuge = window.zhuge || [];
		window.zhuge.methods = "_init identify track getDid getSid getKey setSuperProperty setUserProperties setWxProperties setPlatform".split(" ");
		window.zhuge.factory = function(b) {
		return function() {
			var a = Array.prototype.slice.call(arguments);
			a.unshift(b);
			window.zhuge.push(a);
			return window.zhuge;
		}
		};
		for (var i = 0; i < window.zhuge.methods.length; i++) {
		var key = window.zhuge.methods[i];
		window.zhuge[key] = window.zhuge.factory(key);
		}
		window.zhuge.load = function(b, x) {
		if (!document.getElementById("zhuge-js")) {
			var a = document.createElement("script");
			var verDate = new Date();
			var verStr = verDate.getFullYear().toString() + verDate.getMonth().toString() + verDate.getDate().toString();

			a.type = "text/javascript";
			a.id = "zhuge-js";
			a.async = !0;
			a.src = (location.protocol == 'http:' ? "http://sdk.zhugeio.com/zhuge.min.js?v=": 'https://zgsdk.zhugeio.com/zhuge.min.js?v=') + verStr;
			a.onerror = function() {
			window.zhuge.identify = window.zhuge.track = function(ename, props, callback) {
				if(callback && Object.prototype.toString.call(callback) === '[object Function]') {
				callback();
				} else if (Object.prototype.toString.call(props) === '[object Function]') {
				props();
				}
			};
			};
			var c = document.getElementsByTagName("script")[0];
			c.parentNode.insertBefore(a, c);

			window.zhuge._init(b, x)
		}
		};
			window.zhuge.load('f375fe2f71e542a4b890d9a620f9fb32', {
				superProperty: {
					'应用名称': '诸葛io'
				},
				debug: false,
				adTrack: false,
				autoTrack: false,
				singlePage: false
			});
	})();
	</script>

	<title>coding-420/simpleframework: 自研框架以及相关的demo - 慕课网Git</title>

	<meta name="theme-color" content="#ff5343">

	

</head>
<body>
	<div class="full height">
		<noscript>Please enable JavaScript in your browser!</noscript>

		
			<div class="following bar gray">

				<div class="ui container">
					<div class="ui grid">
						<div class="column">
							<div class="ui top secondary menu definemenu">
								<a class="item brand" href="/">
									<img class="ui mini image" src="/img/favicon.png">
								</a>

								
									<a class="item" href="/issues">任务管理</a>
									<a class="item" href="/pulls">合并请求</a>
								

								<a class="item" href="/explore/repos" style="display: none;">发现</a>

								
									<div class="right menu">
									
									
										<div class="ui dropdown head link jump item poping up" data-variation="tiny inverted" style="height: 52px;">
											<span class="text">
												<i class="octicon octicon-plus"><span class="sr-only">创建...</span></i>
												<i class="octicon octicon-triangle-down"></i>
											</span>
											<div class="menu">
												<a class="item" href="/repo/create">
													<i class="octicon octicon-plus"></i> 创建仓库
												</a>
												<a class="item" href="/repo/migrate">
													<i class="octicon octicon-repo-clone"></i> 迁移外部仓库
												</a>
												
												<a class="item" href="/org/create">
													<i class="octicon octicon-organization"></i> 创建新的组织
												</a>
												
											</div>
										</div>
									
										<div class="ui dropdown head link jump item poping up mr0" tabindex="-1" data-variation="tiny inverted">
											<span class="text avatar">
												<img class="ui avatar image" src="//img.mukewang.com/5633792b0001ea9301000100-100-100.jpg">
												
												<i class="ellipsis vertical icon" tabindex="-1"></i>
											</span>
											<div class="menu" tabindex="-1">
												
												<a class="item" href="/CHECKTREES">
													<i class="octicon octicon-person"></i>
													个人主页
												</a>
												<a class=" item" href="/user/settings/ssh">
													<i class="octicon octicon-settings"></i>
													用户设置
												</a>
												<a class="item" target="_blank" href="//www.imooc.com/help/cate/27" rel="noreferrer">
													<i class="octicon octicon-question"></i>
													帮助
												</a>
												

												<div class="divider"></div>
												<a  class="item" href="//git.imooc.com/passport/user/logout?referer=//git.imooc.com">
													<i class="octicon octicon-sign-out"></i>
													退出
												</a>
											</div>
										</div>
									</div>

								
							</div>
						</div>
					</div>
				</div>
			</div>
		


<div class="repository file list">
	<div class="header-wrapper">

	<div class="ui container">
		<div class="ui vertically padded grid head">
			<div class="column">
				<div class="ui header">
					<div class="ui huge breadcrumb">
						<i class="mega-octicon octicon-lock"></i>
						<a href="/coding-420">Spring源码解析</a>
						<div class="divider"> / </div>
						<a href="/coding-420/simpleframework">simpleframework</a>
						
						
					</div>

					
						<div class="ui right">
							<div class="ui labeled button" tabindex="0">
								<a class="ui basic button" href="/coding-420/simpleframework/action/unwatch?redirect_to=%2fcoding-420%2fsimpleframework%2fsrc%2fmaster%2fsrc%2fmain%2fwebapp%2ftemplates%2faddheadline.jsp">
									<i class="icon fa-eye"></i>取消关注
								</a>
								<a class="ui basic label" href="/coding-420/simpleframework/watchers">
									1251
								</a>
							</div>
							<div class="ui labeled button" tabindex="0">
								<a class="ui basic button" href="/coding-420/simpleframework/action/star?redirect_to=%2fcoding-420%2fsimpleframework%2fsrc%2fmaster%2fsrc%2fmain%2fwebapp%2ftemplates%2faddheadline.jsp">
									<i class="icon fa-star-o"></i>点赞
								</a>
								<a class="ui basic label" href="/coding-420/simpleframework/stars">
									8
								</a>
							</div>
							
								<div class="ui labeled button" tabindex="0">
									<a class="ui basic button " href="/repo/fork/14035">
										<i class="octicon octicon-repo-forked"></i>Fork
									</a>
									<a class="ui basic label" href="/coding-420/simpleframework/forks">
										30
									</a>
								</div>
							
						</div>
					
				</div>
			</div>
		</div>
	</div>


	<div class="ui tabs container">
		<div class="ui tabular menu navbar">
			
				<a class="active item" href="/coding-420/simpleframework">
					<i class="octicon octicon-file-text"></i> 代码
				</a>
			
			
				<a class=" item" href="/coding-420/simpleframework/issues">
					<i class="octicon octicon-issue-opened"></i> Issues <span class="ui small label">0</span>
				</a>
			
			
				<a class=" item" href="/coding-420/simpleframework/pulls">
					<i class="octicon octicon-git-pull-request"></i> Pull Requests <span class="ui small label">0</span>
				</a>
			
			
				<a class=" item" href="/coding-420/simpleframework/wiki">
					<i class="octicon octicon-book"></i> Wiki
				</a>
			
			
		</div>
	</div>
	<div class="ui tabs divider"></div>

</div>

	<div class="ui container">
		




		<div style="position:relative;width:980px;height:36px;background:#fff9f5;font-size:12px;font-weight:400;font-family:PingFangSC-Regular;border:1px solid #ffd5a1;border-radius:4px;line-height:36px;margin-bottom:26px;color:#e98000;">
			<div style="text-indent:15px;">温馨提示：Git用户名 / &nbsp;Username: CHECKTREES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Git密码 / &nbsp;Password: 为慕课网登录密码</div>
			<div style="position:absolute;top:0px;right:17px;font-size:14px;font-weight:400;">
				<a style="color:#f20d0d;" href="https://www.imooc.com/user/newforgot" target="_blank">重置密码</a>
			</div>
		</div>
		
		<div class="ui secondary menu">
			<div class="fitted item choose reference">
	<div class="ui floating filter dropdown" data-no-results="未找到结果">
			<div class="ui basic small button">
			<span class="text">
				<i class="octicon octicon-git-branch"></i>
				分支:
				<strong class="branch_text">master</strong>
			</span>
			<i class="dropdown icon"></i>
		</div>
		<div class="menu">
			<div class="ui icon search input">
				<i class="filter icon"></i>
				<input name="search" placeholder="过滤分支或标签...">
			</div>
			<div class="header">
				<div class="ui grid">
					<div class="two column row">
						<a class="reference column" href="#" data-target="#branch-list">
							<span class="text black">
								分支列表
							</span>
						</a>
						<a class="reference column" href="#" data-target="#tag-list">
							<span class="text ">
								标签列表
							</span>
						</a>
					</div>
				</div>
			</div>
			<div id="branch-list" class="scrolling menu" >
				
					<div class="item selected" data-url="/coding-420/simpleframework/src/master/src/main/webapp/templates/addheadline.jsp">master</div>
				
			</div>
			<div id="tag-list" class="scrolling menu" style="display: none">
				
			</div>
		</div>
	</div>
</div>

			
			<div class="fitted item">
				
				
				
					<div class="ui breadcrumb">
						<a class="section" href="/coding-420/simpleframework/src/master">simpleframew...</a>
						
							<div class="divider"> / </div>
							
								
								<span class="section"><a href="/coding-420/simpleframework/src/master/src">src</a></span>
							
						
							<div class="divider"> / </div>
							
								
								<span class="section"><a href="/coding-420/simpleframework/src/master/src/main">main</a></span>
							
						
							<div class="divider"> / </div>
							
								
								<span class="section"><a href="/coding-420/simpleframework/src/master/src/main/webapp">webapp</a></span>
							
						
							<div class="divider"> / </div>
							
								
								<span class="section"><a href="/coding-420/simpleframework/src/master/src/main/webapp/templates">templates</a></span>
							
						
							<div class="divider"> / </div>
							
								<span class="active section">addheadline.jsp</span>
							
						
					</div>
				
			</div>
			<div class="right fitted item">
				
					<div id="file-buttons" class="ui tiny blue buttons">
						
						
					</div>
				

				
					
			</div>
		</div>
		
			<div id="file-content" class="tab-size-8">
	<h4 class="ui top attached header" id="repo-read-file">
		
			<i class="file text outline icon ui left"></i>
			<strong>addheadline.jsp</strong> <span class="text grey normal">750 B</span>
		
		
			<div class="ui right file-actions">
				<div class="ui buttons">
					
						<a class="ui button" href="/coding-420/simpleframework/src/9cc597e0b2ba9384614dd44364db279b45a81911/src/main/webapp/templates/addheadline.jsp">永久链接</a>
					
					<a class="ui button" href="/coding-420/simpleframework/commits/master/src/main/webapp/templates/addheadline.jsp">文件历史</a>
					<a class="ui button" href="/coding-420/simpleframework/raw/master/src/main/webapp/templates/addheadline.jsp">原始文件</a>
				</div>
				
					
						<i class="octicon octicon-pencil btn-octicon poping up disabled" data-content="您必须Fork此仓库才能对此文件进行修改操作" data-position="bottom center" data-variation="tiny inverted"></i>
					
					
						<i class="octicon octicon-trashcan btn-octicon poping up disabled" data-content="您必须具有可写权限才能对此文件进行修改操作" data-position="bottom center" data-variation="tiny inverted"></i>
					
				
			</div>
		
	</h4>
	<div class="ui attached table segment">
		<div id="" class="file-view code-view has-emoji">
			
				<table>
					<tbody>
						<tr>
						
							<td class="lines-num"><span id="L1">1</span><span id="L2">2</span><span id="L3">3</span><span id="L4">4</span><span id="L5">5</span><span id="L6">6</span><span id="L7">7</span><span id="L8">8</span><span id="L9">9</span><span id="L10">10</span><span id="L11">11</span><span id="L12">12</span><span id="L13">13</span><span id="L14">14</span><span id="L15">15</span><span id="L16">16</span><span id="L17">17</span><span id="L18">18</span><span id="L19">19</span></td>
							<td class="lines-code"><pre><code class=""><ol class="linenums"><li class="L1" rel="L1">&lt;%@ page pageEncoding=&#34;UTF-8&#34;%&gt;</li>
<li class="L2" rel="L2">&lt;html&gt;</li>
<li class="L3" rel="L3">    &lt;head&gt;</li>
<li class="L4" rel="L4">        &lt;title&gt;addheadline&lt;/title&gt;</li>
<li class="L5" rel="L5">    &lt;/head&gt;</li>
<li class="L6" rel="L6">    &lt;body&gt;</li>
<li class="L7" rel="L7">        &lt;table&gt;</li>
<li class="L8" rel="L8">            &lt;h2 style=&#34;color: red&#34;&gt; 表单提交：&lt;/h2&gt;&lt;br&gt;</li>
<li class="L9" rel="L9">            &lt;form id=&#34;headlineInfo&#34; method=&#34;post&#34; action=&#34;/simpleframework/headline/add&#34;&gt;</li>
<li class="L10" rel="L10">                头条说明:&lt;input type=&#34;text&#34; name=&#34;lineName&#34;&gt;&lt;br&gt;</li>
<li class="L11" rel="L11">                头条链接:&lt;input type=&#34;text&#34; name=&#34;lineLink&#34;&gt;&lt;br&gt;</li>
<li class="L12" rel="L12">                头条图片地址:&lt;input type=&#34;text&#34; name=&#34;lineImg&#34;&gt;&lt;br&gt;</li>
<li class="L13" rel="L13">                优先级:&lt;input type=&#34;text&#34; name=&#34;priority&#34;&gt;&lt;br&gt;</li>
<li class="L14" rel="L14">                结果：&lt;h3&gt;状态码：${result.code} 信息：${result.msg}&lt;/h3&gt;&lt;br&gt;</li>
<li class="L15" rel="L15">                &lt;input type=&#34;submit&#34; value=&#34;提交&#34;&gt;</li>
<li class="L16" rel="L16">            &lt;/form&gt;</li>
<li class="L17" rel="L17">        &lt;/table&gt;</li>
<li class="L18" rel="L18">    &lt;/body&gt;</li>
<li class="L19" rel="L19">&lt;/html&gt;</li>
</ol></code></pre></td>
						
						</tr>
					</tbody>
				</table>
			
		</div>
	</div>
</div>

<script>
function submitDeleteForm() {
    var message = prompt("delete_confirm_message\n\ndelete_commit_summary", "Delete ''");
    if (message != null) {
        $("#delete-message").val(message);
        $("#delete-file-form").submit()
    }
}
</script>

		
	</div>
</div>

	</div>
	
	<div id="J_GotoTop" class="elevator">
		<a href="//www.imooc.com/user/feedback" class="elevator-msg" target="_blank">
			<i class="imv2-feedback"></i>
			<span class="">意见反馈</span>
		</a>
		<a href="//www.imooc.com/help/cate/27" class="elevator-faq" target="_blank">
			<i class="imv2-help icon blue"></i>
			<span class="">帮助中心</span>
		</a>
		
		<a href="javascript:void(0)" class="elevator-weixin no-goto" id="js-elevator-weixin" >
			<i class="imv2-weixigzh"></i>
			<span class="">官方微信</span>
			<div class="elevator-weixin-box"></div>
		</a>
		<a href="javascript:void(0)" class="elevator-top no-goto" style="display:none" id="backTop">
			<i class="imv2-arrow2_u"></i>
			<span class="">返回顶部</span>
		</a>
	</div>
	<footer>
		<div class="ui container">
			<div class="ui left">Copyright © 2018 imooc.com All Rights Reserved | 京ICP备 12003892号-11</div>
			<div class="ui right links">
				<div class="ui language bottom floating upward slide up dropdown link item">
					<i class="world icon"></i>
					<div class="text">简体中文</div>
					<div class="menu">
						
							<a class="item active selected" href="#">简体中文</a>
						
							<a class="item " href="/coding-420/simpleframework/src/master/src/main/webapp/templates/addheadline.jsp?lang=en-US">English</a>
						
							<a class="item " href="/coding-420/simpleframework/src/master/src/main/webapp/templates/addheadline.jsp?lang=zh-HK">繁體中文</a>
						
					</div>
				</div>
			</div>
		</div>
	</footer>

<script>
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?f0cfcccd7b1393990c78efdeebff3968";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>


<div style="display: none;">
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?84d74dc9bf9efbc24efce88f71f831cb";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

</div>
</body>



	<link rel="stylesheet" href="/plugins/highlight-9.6.0/github.css">
	<script src="/plugins/highlight-9.6.0/highlight.pack.js"></script>




<script src="/js/libs/emojify-1.1.0.min.js"></script> 
<script src="/js/libs/clipboard-1.5.9.min.js"></script>

</html>

