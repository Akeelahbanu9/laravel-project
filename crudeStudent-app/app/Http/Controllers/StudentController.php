<?php

namespace App\Http\Controllers;


use App\Http\Resources\StudentResource;
use App\Models\Student;
use App\Http\Requests\StoreStudentRequest;
use App\Http\Requests\UpdateStudentRequest;
use App\Domain\Student\StudentFacade;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Str;

class StudentController extends Controller
{

    public function index()
    {
        return inertia("Student/Index",[
            'students'=> StudentResource::collection(Student::all())
        ]);
    }


    public function create()
    {
        return inertia("Student/Create");
    }

    public function store(StoreStudentRequest $request)
    {
        StudentFacade::create($request);
        return to_route('student.index')
            ->with('message', 'Student was created');

    }


    public function show(Student $student)
    {
        return inertia("Student/Show",[
            'student'=> new StudentResource($student)
        ]);
    }


    public function edit(Student $student)
    {
        return inertia("Student/Edit",[
            'student' => $student
        ]);
    }

    public function update(UpdateStudentRequest $request, Student $student)
    {
        StudentFacade::update($request,$student);
        return to_route('student.show',$student)
            ->with('message', "Student \"$student->name\" was updated");
    }


    public function destroy(Student $student)
    {
        StudentFacade::delete($student);
        return redirect('/student')->with('message',"Student Deleted");
    }
}
