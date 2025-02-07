<%--
  Created by IntelliJ IDEA.
  User: cjt
  Date: 2020/7/3
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

      <meta charset="UTF-8">

      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <meta http-equiv="X-UA-Compatible" content="ie=edge">

      <title>教博会门票扫描器</title>

      <script src="https://cdn.bootcss.com/vConsole/3.2.0/vconsole.min.js"></script>

      <script type="text/javascript" src="js/llqrcode.js"></script>

      <script>

    let vConsole = new VConsole();

</script>

      <style>

        #scan {

              position: fixed;

              bottom: 5px;

              left: 50%;

              transform: translateX(-50%);

              display: block;

              text-decoration: none;

              margin: 0 auto;

              width: 100%;

              line-height: 2.5rem;

              text-decoration: none;

              color: #fff;

              text-align: center;

              border-radius: 20px 20px 20px 20px;

              font-size: .8rem;

              background-color: #0E76E1;

            }

        #qr-canvas {

              margin: 0px auto;      

          max-width: 300px;

            }

        #video{

              margin: 0px auto;

            }

      </style>

</head>

 

<body>

  

  <div id="output"></div>

  <!-- 由于llqrcode.js中写死了id，所以id必须为qr-canvas -->

  <video id="video" muted autoplay playsinline width="300" height="200"></video>

  <canvas id="qr-canvas" style="display:none;"></canvas>

  <a href="javascript:;" id="scan">扫码</a>

  <script type="text/javascript">

    const Scan = {

        videoInputDevice: [],

        videoElement: document.getElementById("video"),

        canvasElement: document.getElementById("qr-canvas"),

        decodeTimer: null,

        canvasTimer: null,

        canvasContext: document.getElementById("qr-canvas").getContext("2d"),

        // 获取到的媒体设备

        gotDevices (deviceInfos) {

            let that = this;

            for (let i = 0; i !== deviceInfos.length; ++i) {

                let deviceInfo = deviceInfos[i];

                if (deviceInfo.kind === 'audioinput') {

                    // 音频设备

                } else if (deviceInfo.kind === 'videoinput') {

                    // 视频设备

                    that.videoInputDevice.push(deviceInfo);

                } else {

                    // 其他设备

                    console.log('Found one other kind of source/device: ', deviceInfo);

                }

            }

        },

        getStream () {

            let that = this;

            if (window.stream) {

                window.stream.getTracks().forEach((track) => {

                    track.stop();

            });

            }

            // if(that.isIOS){

            //     let constraints = {

            //         video: { facingMode: { exact: "environment" } }

            //       };

            //     console.log('3: ', constraints);

            //     // let constraints = {

            //     //   video: {

            //     //     // environment表示后置摄像头

            //     //     // user表示前置摄像头

            //     //     facingMode: ("environment")

            //     //   }

            //     // };

            // }else{

            let constraints = {

                // 包含audio 可声明音频设备调用

                // 声明视频设备调用

                // video: true

                video: {

                    deviceId: {

                        // [1].deviceId 表示后置摄像头,默认开启的是前置摄像头

                        exact: that.videoInputDevice[1].deviceId

                    }

                }

            };

            // }



            // 视频设备初始化

            navigator.mediaDevices.getUserMedia(constraints).then(that.gotStream.bind(that)).catch(that.handleError.bind(that));

            that.captureToCanvas();

            that.decode();

        },



        // 解码

        decode () {

            let that = this;

            try {

                qrcode.decode();

            } catch (e) {

                console.log('1:'+e);

            };

            that.decodeTimer = setTimeout(that.decode.bind(that),100); // 解码频率为100毫秒一次

        },



        //将视频流放到画布

        captureToCanvas () {

            let that = this;

            try {

                // 根据视频大小设置canvas大小

                let w = that.videoElement.videoWidth;

                let h = that.videoElement.videoHeight;

                that.canvasElement.width = w;

                that.canvasElement.height = h;

                that.canvasContext.drawImage(that.videoElement, 0, 0, w, h);

            } catch (e) {

                console.log(e);

            };

            // 100毫秒绘制一次

            that.canvasTimer = setTimeout(that.captureToCanvas.bind(that),100);

        },



        handleError (error) {

            console.log('Error: ', error);

        },



        gotStream (stream) {

            let that = this;

            window.stream = stream; // make stream available to console

            that.videoElement.srcObject = stream;

        },

        isIOS(){

            var u = navigator.userAgent;

            var IOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端

            if(IOS){

                return true;

            }else{

                return false;

            }

        },

        init () {

            let that = this;

            // API参考

            // https://developer.mozilla.org/zh-CN/docs/Web/API/MediaDevices/enumerateDevices

            // 先获取设备列表，方便调用后置摄像头

            let devices = navigator.mediaDevices.enumerateDevices().then(that.gotDevices.bind(that));

            document.querySelector('#scan').addEventListener('click', () => {

                document.getElementById('output').innerHTML = '';

            that.videoElement.style.display = 'block';

            // that.canvasElement.style.display = 'block';

            that.videoElement.play();



            devices.then(that.getStream.bind(that)).catch(that.handleError.bind(that));



            that.canvasContext.clearRect(0, 0, 300, 200);

            //结果回调

            qrcode.callback = (e) => {

                // 清除画布，停止摄像头

                clearTimeout(that.decodeTimer);

                clearTimeout(that.canvasTimer);

                that.canvasContext.clearRect(0, 0, 300, 200);

                if (window.stream) {

                    window.stream.getTracks().forEach((track) => {

                        track.stop();

                });

                }

                that.videoElement.style.display = 'none';

                that.canvasElement.style.display = 'none';

                if(e.indexOf("http")!=-1){

                    window.location.href=e+'&token=xxxx';

                }else {

                    document.getElementById('output').innerHTML = '结果：' + e;

                }

            }

        });

        }

    };

    Scan.init();

</script>

</body>

</html>
