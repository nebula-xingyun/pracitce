<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/7/4
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- index.html -->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Suporka Vue App</title>
    <style>
        .container {
            padding: 60px;
            margin: 0 auto;
            line-height: 50px;
        }
        input {
            display: inline-block;
            width: 200px;
            height: 32px;
            line-height: 1.5;
            padding: 4px 7px;
            font-size: 12px;
            border: 1px solid #dcdee2;
            border-radius: 4px;
            color: #515a6e;
            background-color: #fff;
            background-image: none;
            position: relative;
            cursor: text;
            transition: border 0.2s ease-in-out, background 0.2s ease-in-out,
            box-shadow 0.2s ease-in-out;
        }
        button {
            color: #fff;
            background-color: #19be6b;
            border-color: #19be6b;
            outline: 0;
            vertical-align: middle;
            line-height: 1.5;
            display: inline-block;
            font-weight: 400;
            text-align: center;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            background-image: none;
            border: 1px solid transparent;
            white-space: nowrap;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            padding: 5px 15px 6px;
            font-size: 12px;
            border-radius: 4px;
            transition: color 0.2s linear, background-color 0.2s linear,
            border 0.2s linear, box-shadow 0.2s linear;
        }
        #qrcode {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <input
            type="text"
            placeholder="请输入您想转化成二维码的字符串"
            id="input"
    />
    <button onclick="creatQRcode();">一键生成</button>
    <div id="qrcode"></div>

    <a href="javascript:void(0);" onclick="downloads();">点击下载</a>
</div>
<!-- <script src="https://zxpsuper.github.io/Demo/qrcode/qrcode-dev.js"></script> -->
<script src="./qrcode-dev.js"></script>
<script type="text/javascript">
    var qrcode = null;
    function creatQRcode() {
        document.getElementById("qrcode").innerHTML = "";
        qrcode = new QRCode(document.getElementById("qrcode"), {
            text: document.getElementById("input").value,
            width: 200,
            height: 200,
            colorDark: "#000000",
            colorLight: "#ffffff",
            correctLevel: QRCode.CorrectLevel.H
        });
    }

    function downloads() {
        console.log(document.getElementById("qrcode-image").src);
        let data = document.getElementById("qrcode-image").src;
        let aLink = document.createElement("a");
        let blob = base64ToBlob(data); //new Blob([content]);

        let evt = document.createEvent("HTMLEvents");
        evt.initEvent("click", true, true); //initEvent 不加后两个参数在FF下会报错  事件类型，是否冒泡，是否阻止浏览器的默认行为
        aLink.download = "fileName";
        aLink.href = URL.createObjectURL(blob);

        aLink.dispatchEvent(
            new MouseEvent("click", {
                bubbles: true,
                cancelable: true,
                view: window
            })
        ); //兼容火狐
    }
    //base64转blob
    function base64ToBlob(code) {
        let parts = code.split(";base64,");
        let contentType = parts[0].split(":")[1];
        let raw = window.atob(parts[1]);
        let rawLength = raw.length;

        let uInt8Array = new Uint8Array(rawLength);

        for (let i = 0; i < rawLength; ++i) {
            uInt8Array[i] = raw.charCodeAt(i);
        }
        return new Blob([uInt8Array], { type: contentType });
    }
</script>
</body>
</html>
