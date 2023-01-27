<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">



<title>My Relatives</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

<style>
.container {
  padding: 2rem 0rem;
}

h4 {
  margin: 2rem 0rem 1rem;
}

.table-image {
  td, th {
    vertical-align: middle;
  }
}
main{
    min-height: 90vh;
}
</style>

</head>

<body>
    <main>
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
  <a class="navbar-brand" href="index.jsp">
    <img src="https://i.ibb.co/YQpHjHK/medone-logo-1.png" width="150" height="50" class="d-inline-block align-top" alt="">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="./report?action=viewAll">My Reports</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="doctor.jsp">My Doctors</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="chat.jsp">Consult Online</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="relative_list.jsp">My Relatives</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./patients?action=logout">Logout</a>
      </li>    
    </ul>
  </div>  
</nav>
    
    <div class="container">
        <div class="row">
          <div class="col-12">
              <table class="table table-image">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Image</th>
                    <th scope="col">Name</th>
                    <th scope="col">Phone no.</th>
                    <th scope="col">Address</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">1</th>
                    <td class="w-25">
                        <img src="https://www.dlf.pt/dfpng/middlepng/569-5693658_dummy-user-image-png-transparent-png.png" class="img-fluid img-thumbnail" alt="Sheep">
                    </td>
                    <td>John</td>
                    <td>000000000</td>
                    <td>Barishal</td>
                    <td><a href="#" class="nav-link">See Profile</a><br><a href="#" class="nav-link">Remove</a></td>
                  </tr>
                  <tr>
                    <th scope="row">2</th>
                    <td class="w-25">
                        <img src="https://www.dlf.pt/dfpng/middlepng/569-5693658_dummy-user-image-png-transparent-png.png" class="img-fluid img-thumbnail" alt="Sheep">
                    </td>
                    <td>Phil</td>
                    <td>11111111</td>
                    <td>Noakhali</td>
                    <td><a href="#" class="nav-link">See Profile</a><br><a href="#" class="nav-link">Remove</a></td>
                  </tr>
                </tbody>
              </table>   
          </div>
        </div>
      </div>
    </main>

    <footer class="text-center text-lg-start bg-light text-muted">
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
          © 2023 Copyright:
          <p class="text-reset fw-bold ">Holy Bugs</p>
        </div>
      </footer>

</body>