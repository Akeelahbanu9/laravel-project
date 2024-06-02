<?php

namespace App\Domain\Student;

use App\Http\Requests\StoreStudentRequest;
use App\Http\Requests\UpdateStudentRequest;
use App\Models\Student;
use Illuminate\Support\Facades\Facade;

/**
 * @method static array create(StoreStudentRequest $request)
 * @see StudentService
 *
 * @method static array update(UpdateStudentRequest $request, Student $student)
 * @see StudentService
 *
 * @method static array delete(Student $student)
 * @see StudentService
 */

class StudentFacade extends Facade
{
    protected static function getFacadeAccessor()
    {
        return StudentService::class;
    }

}

