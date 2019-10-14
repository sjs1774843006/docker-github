/**
 * GB-canvas-turntable.js
 * @class gbTurntable
 * @see https://github.com/givebest/GB-canvas-turntable
 * @author givenlovs@msn.com
 * @(c) 2016
 **/


(function () {
    var $,
        ele,
        container,
        canvas,
        num,
        prizes,
        btn,
        deg = 0,
        fnGetPrize,
        fnGotBack,
        optsPrize;

    var cssPrefix,
        eventPrefix,
        vendors = {
            '': '',
            Webkit: 'webkit',
            Moz: '',
            O: 'o',
            ms: 'ms'
        },
        testEle = document.createElement('p'),
        cssSupport = {};

    // 鍡呮帰鐗规€�
    Object.keys(vendors).some(function (vendor) {
        if (testEle.style[vendor + (vendor ? 'T' : 't') + 'ransitionProperty'] !== undefined) {
            cssPrefix = vendor ? '-' + vendor.toLowerCase() + '-' : '';
            eventPrefix = vendors[vendor];
            return true;
        }
    });

    /**
     * [鍏煎浜嬩欢鍓嶇紑]
     * @param  {[type]} name [description]
     * @return {[type]}      [description]
     */
    function normalizeEvent(name) {
        return eventPrefix ? eventPrefix + name : name.toLowerCase();
    }

    /**
     * [鍏煎CSS鍓嶇紑]
     * @param  {[type]} name [description]
     * @return {[type]}      [description]
     */
    function normalizeCss(name) {
        name = name.toLowerCase();
        return cssPrefix ? cssPrefix + name : name;
    }

    cssSupport = {
        cssPrefix: cssPrefix,
        transform: normalizeCss('Transform'),
        transitionEnd: normalizeEvent('TransitionEnd')
    }

    var transform = cssSupport.transform;
    var transitionEnd = cssSupport.transitionEnd;

    // alert(transform);
    // alert(transitionEnd);

    function init(opts) {
        fnGetPrize = opts.getPrize;
        fnGotBack = opts.gotBack;

        opts.config(function (data) {
            prizes = opts.prizes = data;
            num = prizes.length;
            draw(opts);
        });

        events();
    }

    /**
     * @param  {String} id
     * @return {Object} HTML element
     */
    $ = function (id) {
        return document.getElementById(id);
    };

    /**
     * [缁樺埗杞洏]
     * @param  {String} id
     * @param  {Number} 濂栧搧浠芥暟
     */
    function draw(opts) {
        opts = opts || {};
        if (!opts.id || num >>> 0 === 0) return;

        var id = opts.id,
            rotateDeg = 360 / num / 2 + 90, // 鎵囧舰鍥炶浆瑙掑害
            ctx,
            prizeItems = document.createElement('ul'), // 濂栭」瀹瑰櫒
            turnNum = 1 / num, // 鏂囧瓧鏃嬭浆 turn 鍊�
            html = []; // 濂栭」

        ele = $(id);
        canvas = ele.querySelector('.gb-turntable-canvas');
        container = ele.querySelector('.gb-turntable-container');
        btn = ele.querySelector('.gb-turntable-btn');

        if (!canvas.getContext) {
            showMsg('鎶辨瓑锛佹祻瑙堝櫒涓嶆敮鎸併€�');
            return;
        }
        // 鑾峰彇缁樺浘涓婁笅鏂�
        ctx = canvas.getContext('2d');

        for (var i = 0; i < num; i++) {
            // 淇濆瓨褰撳墠鐘舵€�
            ctx.save();
            // 寮€濮嬩竴鏉℃柊璺緞
            ctx.beginPath();
            // 浣嶇Щ鍒板渾蹇冿紝涓嬮潰闇€瑕佸洿缁曞渾蹇冩棆杞�
            ctx.translate(150, 150);
            // 浠�(0, 0)鍧愭爣寮€濮嬪畾涔変竴鏉℃柊鐨勫瓙璺緞
            ctx.moveTo(0, 0);
            // 鏃嬭浆寮у害,闇€灏嗚搴﹁浆鎹负寮у害,浣跨敤 degrees * Math.PI/180 鍏紡杩涜璁＄畻銆�
            ctx.rotate((360 / num * i - rotateDeg) * Math.PI / 180);
            // 缁樺埗鍦嗗姬
            ctx.arc(0, 0, 150, 0, 2 * Math.PI / num, false);

            // 棰滆壊闂撮殧
            if (i % 2 == 0) {
                ctx.fillStyle = '#ffb820';
            } else {
                ctx.fillStyle = '#ffcb3f';
            }

            // 濉厖鎵囧舰
            ctx.fill();
            // 缁樺埗杈规
            ctx.lineWidth = 0.5;
            ctx.strokeStyle = '#e4370e';
            ctx.stroke();

            // 鎭㈠鍓嶄竴涓姸鎬�
            ctx.restore();

            // 濂栭」鍒楄〃
            var prizeList = opts.prizes;
            html.push('<li class="gb-turntable-item"> <span style="');
            html.push(transform + ': rotate(' + i * turnNum + 'turn)">');
            !!prizeList[i].img ? html.push('<img src="' + prizeList[i].img + '" />') : html.push(prizeList[i].text)
            html.push('</span> </li>');
            if ((i + 1) === num) {
                prizeItems.className = 'gb-turntalbe-list';
                container.appendChild(prizeItems);
                prizeItems.innerHTML = html.join('');
            }

        }

    }

    /**
     * [鎻愮ず]
     * @param  {String} msg [description]
     */
    function showMsg(msg) {
        alert(msg);
    }

    /**
     * [鍒濆鍖栬浆鐩榏
     * @return {[type]} [description]
     */
    /*  function runInit() {
        removeClass(container, 'gb-run');
        container.style[transform] = 'rotate(0deg)';
        container.style[transform] = '';
      }*/

    /**
     * 鏃嬭浆杞洏
     * @param  {[type]} deg [description]
     * @return {[type]}     [description]
     */
    function runRotate(deg) {
        // runInit();

        // setTimeout(function() {
        // addClass(container, 'gb-run');
        container.style[transform] = 'rotate(' + deg + 'deg)';
        // }, 10);
    }



    function numCount(){
        var count = $("number").innerText;
        if (count == 0){
            alert("抽奖次数不足")
            addClass(btn, 'disabled');
        }else{
            $("number").innerText = count-1;
            addClass(btn, 'disabled');
            fnGetPrize(function (data) {
                optsPrize = {
                    prizeId: data[0],
                    chances: data[1]
                }
                // 璁＄畻鏃嬭浆瑙掑害
                deg = deg || 0;
                deg = deg + (360 - deg % 360) + (360 * 10 - data[0] * (360 / num))
                runRotate(deg);
            });
            // 涓鎻愮ず
            bind(container, transitionEnd, eGot);
        }
    }


    /**
     * 鎶藉浜嬩欢
     * @return {[type]} [description]
     */
    function events() {
        bind(btn, 'click', function () {
            /*      var prizeId,
                      chances;*/
            numCount();
        });
    }

    function eGot() {
        if (optsPrize.chances) removeClass(btn, 'disabled');
        fnGotBack(prizes[optsPrize.prizeId].text);
    }


    /**
     * Bind events to elements
     * @param {Object}    ele    HTML Object
     * @param {Event}     event  Event to detach
     * @param {Function}  fn     Callback function
     */
    function bind(ele, event, fn) {
        if (typeof addEventListener === 'function') {
            ele.addEventListener(event, fn, false);
        } else if (ele.attachEvent) {
            ele.attachEvent('on' + event, fn);
        }
    }

    /**
     * Unbind events to elements
     * @param {Object}    ele    HTML Object
     * @param {Event}     event  Event to detach
     * @param {Function}  fn     Callback function
     */
    /*  function unbind(ele, event, fn) {
          if (typeof removeEventListener === 'function') {
              ele.removeEventListener(event, fn, false);
          } else if (ele.detachEvent) {
              ele.detach('on' + event, fn);
          }
      }*/

    /**
     * hasClass
     * @param {Object} ele   HTML Object
     * @param {String} cls   className
     * @return {Boolean}
     */
    function hasClass(ele, cls) {
        if (!ele || !cls) return false;
        if (ele.classList) {
            return ele.classList.contains(cls);
        } else {
            return ele.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
        }
    }

    // addClass
    function addClass(ele, cls) {
        if (ele.classList) {
            ele.classList.add(cls);
        } else {
            if (!hasClass(ele, cls)) ele.className += '' + cls;
        }
    }

    // removeClass
    function removeClass(ele, cls) {
        if (ele.classList) {
            ele.classList.remove(cls);
        } else {
            ele.className = ele.className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|$)', 'gi'), ' ');
        }
    }

    var gbTurntable = {
        init: function (opts) {
            return init(opts);
        }
    }

    // (@see https://github.com/madrobby/zepto/blob/master/src/zepto.js)
    window.gbTurntable === undefined && (window.gbTurntable = gbTurntable);

    // AMD (@see https://github.com/jashkenas/underscore/blob/master/underscore.js)
    if (typeof define == 'function' && define.amd) {
        define('GB-canvas-turntable', [], function () {
            return gbTurntable;
        });
    }

}());