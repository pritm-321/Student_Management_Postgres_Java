function validateId() {
  var x = document.forms["Input"]["id"].value;
  if (x == "" || x == null || x== " ") {
    alert("Please !! Enter your Id ");
    return false;
  }
}

function deleteAll() {
	alert("All Students Deleted successfully !");  
}

function deletebyID() {
	alert("Student Deleted successfully !");  
}

function saved() {
  	alert("Student Saved successfully !");
}

function updated() {
  	alert("Student Updated Successfully !");
}