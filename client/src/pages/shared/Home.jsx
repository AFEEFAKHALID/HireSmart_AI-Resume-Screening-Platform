function Home() {
  return (
    <div className="min-h-screen bg-slate-100 flex items-center justify-center">
      <div className="bg-white shadow-xl rounded-2xl p-10 text-center">
        <h1 className="text-5xl font-bold text-blue-700">
          HireSmart
        </h1>

        <p className="text-gray-600 mt-4 text-xl">
          AI Resume Screening Platform
        </p>

        <button className="mt-8 bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-lg transition">
          Get Started
        </button>
      </div>
    </div>
  );
}

export default Home;