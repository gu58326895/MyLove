<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>

    <link href="/lib/bootstrap-3.3.5-dist/css/bootstrap.css" ref="stylesheet" media="screen">
    <link href="/lib/bootstrap-3.3.5-dist/css/bootstrap-datetimepicker.css" ref="stylesheet" media="screen">


    <script src="/lib/jquery/jquery-2.1.3.min.js"></script>
    <script src="/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script src="/lib/bootstrap-3.3.5-dist/js/bootstrap-datetimepicker.js"></script>
    <script src="/lib/bootstrap-3.3.5-dist/js/locales/bootstrap-datetimepicker.fr.js"></script>


</head>
<body>

   <div class="input-append date form_datetime">
       <input size="16" type="text" value="" readonly>
       <span class="add-on"><i class="icon-th"></i></span>
   </div>

</body>
<script type="text/javascript">
     $(".form_datetime").datetimepicker({
            format: "dd MM yyyy - hh:ii"
        });
</script>
</html>