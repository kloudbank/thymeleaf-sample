/*!
* Start Bootstrap - Simple Sidebar v6.0.6 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

  // Toggle the side navigation
  const sidebarToggle = document.body.querySelector('#sidebarToggle');
  if (sidebarToggle) {
    // Uncomment Below to persist sidebar toggle between refreshes
    // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
    //     document.body.classList.toggle('sb-sidenav-toggled');
    // }
    sidebarToggle.addEventListener('click', event => {
      event.preventDefault();
      document.body.classList.toggle('sb-sidenav-toggled');
      localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
    });
  }

});

$('#signinBtn').click(function (self) {

  var accountTemp = new Object();
  accountTemp.userid = $('#signinUserid').val();
  accountTemp.password = $('#signinPassword').val();
  accountTemp.username = '';

  if (accountTemp.userid == "" || accountTemp.password == "") {
    alert("Input userid or password");
    return;
  }

  var account = JSON.stringify(accountTemp);

  $.ajax({
    url: '/v1/login'
    , type: 'POST'
    , dataType: 'json'
    , contentType: 'application/json; charset=UTF-8'
    , data: account
    , success: function (result) {
      alert("Signin success!");
      $(location).attr('href', '/index');
    }
    , error: function (result) {
      alert("Signin failed! but go index page");
    }
  });
});

