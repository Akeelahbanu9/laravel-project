<?php

namespace App\Domain\Student;

use App\Http\Requests\StoreStudentRequest;
use App\Http\Requests\UpdateStudentRequest;
use App\Models\Student;
use Illuminate\Support\Facades\Storage;

class StudentService
{

    public function create(StoreStudentRequest $request){

        $data = $request->validated();
        $image = $data['image'];
        if ($image) {
            $data['image'] = $image->store('student', 'public');
        }

        Student::create($data);

    }

    public function update(UpdateStudentRequest $request, Student $student){

        $data = $request->validated();
        $image = $data['image'] ?? null;

        $student->name = $data['name'];
        $student->age = $data['age'];
        $student->status = $data['status'];

        if ($image) {

            if ($student->image) {
                Storage::disk('public')->deleteDirectory(dirname($student->image));
            }
            $student->image = $image->store('student', 'public');
        }

        $student->save();

    }

    public function delete(Student $student){

        Storage::disk('public')->deleteDirectory(dirname($student->image));
        $student->delete();

    }


}
