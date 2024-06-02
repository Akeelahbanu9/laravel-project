<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreStudentRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'student_id'=> 'required|unique:students',
            'name' => 'required|max:255',
            'image' => 'required|file|mimes:png,jpg,jpeg,webp',
            'age' => 'required|integer',
            'status'=>'required|boolean'
        ];
    }
}
