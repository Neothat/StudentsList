angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudent = function (studentId) {
        $http.get(contextPath + '/students/delete/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.createStudentJson = function () {
        $http.post(contextPath + '/students', $scope.newStudentJson)
            .then(function (response) {
                $scope.loadStudents();
                $scope.newStudentJson = null
            });
    }

    $scope.changeStudentJson = function () {
        $http.post(contextPath + '/students/change_student', $scope.studentJson)
            .then(function (response) {
                $scope.loadStudents();
                $scope.studentJson = null
            });
    }

    $scope.loadStudents();
});