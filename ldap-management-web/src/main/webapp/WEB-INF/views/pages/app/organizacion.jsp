<%@ include file="../common/components/taglibs.jsp"%>
<!DOCTYPE html PUBLIC"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>lib_ggOrgChart v1.0.0beta1 example 2</title>


<script type="text/javascript" src="<c:url value="/assets/vendor/jquery/1.12.1/js/jquery-1.12.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/jspdf-ggorgchart.js" />" ></script>
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/rgbcolor.js" />"></script> 
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/StackBlur.js" />"></script>
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/canvg.js" />"></script> 
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/raphael-ggorgchart.js" />"></script>  
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/lib_gg_orgchart_v100b1.js" />"></script>
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/drag-on.js" />"></script>
<script type="text/javascript" src="<c:url value="assets/vendor/lib_gg_orgchart-1.0.0-beta-1/js/jsrender.js" />"></script>

<script type="text/javascript">


    // these values define only minimal options for the organizational chart look & feel
    // some additional parameters are included for testing zoom, drag and print features
    // 
    var oc_options_4 = {
        data_id           : 2,                       // identifies the ID of the "data" JSON object that is paired with these options
        container         : 'oc_container_4',        // name of the DIV where the chart will be drawn
        max_text_width    : 20,                      // max width (in chars) of each line of text ('0' for no limit)
        box_color          : '#aaf',               // fill color of boxes
        box_color_hover    : '#faa',               // fill color of boxes when mouse is over them
        box_border_color   : '#008',               // stroke color of boxes
        line_color         : '#f44',               // color of connectors
        title_color        : '#000',               // color of titles
        subtitle_color     : '#707',               // color of subtitles
        use_images         : false,  				// use images within boxes?
   		box_click_handler : oc_box_click_handler,    // handler (function) called on click on boxes (set to null if no handler)
    	debug              : false,          		// set to true if you want to debug the library
        use_zoom_print    : true,                    // wheter to use zoom and print or not (only one graph per web page can do so)
        container_supra   : 'oc_supracontainer_4',   // container of the container (DIV); needed for zoom and print
        initial_zoom      : 0.75,                    // initial zoom
        pdf_canvas        : 'oc_print_canvas_4',     // name of the invisible HTML5 canvas needed for print
        pdf_canvas_width  : 800,                     // size of the container (X axis)
        pdf_canvas_height : 480,                     // size of the container (Y axis)
        pdf_filename      : 'orgChart.pdf'           // default filename for PDF printing
    };

    // handler for clicks on nodes
    // this is completely configurable by you
    // here are two examples: showing an alert with the ID and type of the node
    function oc_box_click_handler(event, box) 
	{
        alert('clicked on node with ID = ' + box.oc_id + '; type = ' + box.oc_node.type);   
    }
	
	
    // load the JSON that defines the organizational structure from an external file and inmediatelly render the chart
    // this is an important modification to the 0.4 version of the library; now is imperative to load the JSON from an external file
    // inside the JSON, the "type" attribute for nodes can be: "subordinate", "staff" or "collateral"
    // you can also use the "subtype" attribute for "dashed" nodes (use "subtype:dashed")
    // look the examples and get used to the organizational structure representation
    //
    // IMPORTANT NOTE: because the JSON containing the organizational chart hierarchy is loaded using JQuery (that uses AJAX),
    // this library will work only by loading the JSON from an http server (and not by opening a local file in your browser)
    // the advantage are: separating data and logic, and capability of generating a dynamic JSON from a database (ex. with PHP)
    //
    // now render four versions of the same orgchart; the first one will use zoom, drag and print to PDF
    // modify this function as you want; normally there is no need to draw more than one chart in each web page
    //
    var merged_options = false;
    //
    function ggOrgChart_render ()
    {
        var result;

        // FOURTH PLACE: use zoom, drag and print on a complex organizational chart
        // in order to the "print" feature to work, the rendering should be called before others
        // note, however, that we position ths rendering at the bottom of the web page, so it's a flexible mechanism
        // the "merged_options" variable is needed in order to zoom, drag and zoom to work; see below the respective handlers
        //result = ggOrgChart.render(oc_options_4, "./assets/app/json/demo-ministerio-anonymous.json");
        
        result = ggOrgChart.render(oc_options_4, "./rest/organizacion");
        
        //result = ggOrgChart.render(oc_options_4, "./assets/app/json/demo-policia.json");
        //result = ggOrgChart.render(oc_options_4, "./assets/app/json/demo-organizacion.json");
        
        
        if (result === false) { 
			alert("INFO: render() #4 failed (bad 'options' or 'data' definition)"); 
			return;
		}
        else 
		{ 
			merged_options = result; 
		}

     
    }

    // WINDOW.ONLOAD TASKS
    // put here all the task that should be done when the page finish to load
    // also put here handlers for buttons (like zoom and print), etc.
    //
    window.onload = function () {

        // call the function 'ggOrgChart_render()' defined in this page (just above)
        //
        ggOrgChart_render();        

        $("#oc_btnZommIn").click( function () {
            ggOrgChart.zoom_in(merged_options);
        } );

        $("#oc_btnZommOut").click( function () {
            ggOrgChart.zoom_out(merged_options);
        } );

        $("#oc_btnPrint").click( function () {
            ggOrgChart.print(merged_options);
        } );

    } ;

    //
    // styles used by the chart rendering (first block) and zoom, drag and print features (second block)
    //
    </script>

    <style>
	    .node              { padding-top: 4px; text-align: center; font-size: 13px; }
        .node:first-letter { font-weight: bold; }
		
        .body            { margin: 10px; padding: 0; }
        .text            { font-family: sans-serif; color: blue; text-align: left; }
        .chart_container { margin-left: auto; margin-right: auto; position: relative; width: 70%; }
        #oc_supracontainer_4 {
            position : absolute;
            width    : 800px;
            height   : 480px;
            border   : solid 1px #333333;
            overflow : hidden;
        }
        #oc_content_dragonfly {
            margin-left : 8px;
        }
    </style>

</head>

<body class="body">

    <script type="text/javascript">
    //
    // in order to center the chart in the webpage, you can take two approaches:
    // - use the style as above (.container) in order to define the relative width of the container
    //   note that that width have to be adjusted by hand case-by-case and take in mind this depends of the browser window
    // - use an IFRAME containing the chart inside a main webpage, with scrollbars as needed
    //   this seems to be the preferred way but is not implemented yet
    // we welcome any other way of centering the chart (without using zoom and drag)
    //
    </script>

          
        <div class="chart_container">
        <div>
            <button id="oc_btnZommIn">Zoom in</button>
            <button id="oc_btnZommOut">Zoom out</button>
            <button id="oc_btnPrint">Print</button>
        </div>
        <div id="oc_supracontainer_4">
            <div id="oc_content_dragonfly" class="dragon">
                <div id="oc_container_4"></div>
            </div>
        </div>
        <canvas id="oc_print_canvas_4"></canvas>
        </div>

        <!--/div-->

</body>

</html>
