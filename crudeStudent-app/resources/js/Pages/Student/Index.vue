<template>
    <Head title="Student" />

    <AuthenticatedLayout>
        <template #header>
            <h2
                class="font-semibold text-xl text-gray-800 leading-tight text-center"
            >
                Students List
            </h2>
        </template>

        <div class="py-12">
            <div class="max-w-7xl mx-auto sm:px-6 lg:px-8 space-y-6">
                <div class="p-4 sm:p-8 bg-white shadow sm:rounded-lg">
                    <div
                        v-if="$page.props.message"
                        class="p-4 mb-4 text-sm text-green-800 rounded-lg bg-green-50 dark:bg-gray-800 dark:text-green-400"
                        role="alert"
                    >
                        <span class="font-medium">Success!</span>
                        {{ $page.props.message }}
                    </div>

                    <div class="mt-1 mb-4 flex justify-end">
                        <Link :href="route('student.create')" as="button">
                            <button
                                class="bg-blue-500 text-white px-4 py-2 rounded-lg"
                            >
                                Add Student
                            </button>
                        </Link>
                    </div>

                    <div class="relative overflow-x-auto">
                        <table
                            class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400"
                        >
                            <thead
                                class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
                            >
                                <tr>
                                    <th scope="col" class="px-6 py-3">Image</th>
                                    <th scope="col" class="px-6 py-3">ID</th>
                                    <th scope="col" class="px-6 py-3">Name</th>
                                    <th scope="col" class="px-6 py-3">Age</th>
                                    <th scope="col" class="px-6 py-3">
                                        Status
                                    </th>
                                    <th scope="col" class="px-6 py-3">
                                        Actions
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr
                                    v-if="students.length > 0"
                                    v-for="student in students"
                                    :key="student.id"
                                    class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
                                >
                                    <td class="px-6 py-4">
                                        <img
                                            class="h-auto max-w-xs"
                                            :src="student.image"
                                        />
                                    </td>

                                    <th
                                        scope="row"
                                        class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white"
                                    >
                                        {{ student.student_id }}
                                    </th>

                                    <th
                                        scope="row"
                                        class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white"
                                    >
                                        {{ student.name }}
                                    </th>

                                    <td class="px-6 py-4">
                                        {{ student.age }}
                                    </td>
                                    <td class="px-6 py-4">
                                        <span
                                            v-if="student.status"
                                            class="bg-green-100 text-green-800 text-xs font-medium me-2 px-2.5 py-0.5 rounded"
                                            >Active</span
                                        >
                                        <span
                                            v-else
                                            class="bg-red-100 text-red-800 text-xs font-medium me-2 px-2.5 py-0.5 rounded"
                                            >Inactive</span
                                        >
                                    </td>
                                    <td class="px-6 py-4">
                                        <Link
                                            :href="
                                                route(
                                                    'student.show',
                                                    student.id
                                                )
                                            "
                                            class="text-blue-500 hover:text-blue-700 mr-2"
                                            ><i class="bi bi-eye-fill"></i
                                        ></Link>
                                        <Link
                                            :href="
                                                route(
                                                    'student.edit',
                                                    student.id
                                                )
                                            "
                                            class="text-green-500 hover:text-green-700 mr-2"
                                            ><i class="bi bi-pencil-square"></i
                                        ></Link>
                                        <Link
                                            :href="
                                                route(
                                                    'student.destroy',
                                                    student.id
                                                )
                                            "
                                            method="DELETE"
                                            class="text-red-500 hover:text-red-700 mr-2"
                                            as="button"
                                            ><i class="bi bi-trash"></i
                                        ></Link>
                                    </td>
                                </tr>

                                <tr v-else>
                                    <td class="px-6 py-4">
                                        No records to show
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </AuthenticatedLayout>
</template>

<script setup>
import AuthenticatedLayout from "@/Layouts/AuthenticatedLayout.vue";
import { Head, Link } from "@inertiajs/vue3";

defineProps({
    students: Object,
});
</script>
